package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread{

	private Socket socket;
	private String nickname;
	List<Writer> listWriters;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		String remoteHostAddress = null;
		int remotePort = 0;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			remotePort = remoteInetSocketAddress.getPort();
			ChatServer.log("Connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			while(true) {
				String request = br.readLine();
				if(request==null) {
					ChatServer.log("클라이언트로부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				String[] tokens = request.split(":");
				
				if("join".equals(tokens[0])) {
					   doJoin(tokens[1], pw);
					} else if("message".equals(tokens[0])) {
					   doMessage(tokens[1]);
					} else if("quit".equals(tokens[0])) {
						ChatServer.log("Disconnected by client[" + remoteHostAddress + ":" + remotePort + "]");
					   doQuit(pw);
					   break;
					} else {
					   ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
					}
			}
		}catch (SocketException e) {
			ChatServer.log("Suddenly closed by client[" + remoteHostAddress + ":" + remotePort + "]");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String message) {
		broadcast(message);
	}

	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;
		String data = nickname + "님이 참여하였습니다!";
		broadcast(data);
		addWriter(writer);
		pw.println("채팅방에 참가하였습니다!");
	}
	private void broadcast(String data) {
		   synchronized(listWriters) {
		      for(Writer writer : listWriters) {
				((PrintWriter)writer).println(nickname +": "+ data);
		      }
		   }
		}

	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
}
