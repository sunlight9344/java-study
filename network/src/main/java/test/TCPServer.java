package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			//1. Server Socket 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(Binding0)
			// Socket에 InetSocketAddress(IPAddress_+ port)를 바인딩 한다.
			// IPAddress: 0.0.0.0 를 쓰는 이유는 특정 호스트 IP에 바인딩 하지 않는다.
			// 127.0.0.1 루프백? 자기 자신한테 돌아옴
			serverSocket.bind(new InetSocketAddress("127.0.0.1",5000),10);

			//3. accept
			Socket socket = serverSocket.accept(); // blocking
		
			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();	
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort+"]");
				
				//4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				
				while(true) {
					//5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking 됨 요
					
					if(readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("뿌앵뿌앵뿌뿌뿌[server] closed by client");
						break;
					}
					
					String data = new String(buffer,0,readByteCount,"utf-8");
					System.out.println("[server] received:" + data);
					
					//6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client");
			}
			catch(IOException e) {
				System.out.println("[server] error: " + e);
			} finally {
				try {
					if(socket != null) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("[server] errer:" + e);
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
