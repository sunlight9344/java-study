package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	
	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			
			}
		} catch(SocketException e) {
			System.out.println("채팅방에서 나왔습니다!");
		} catch (IOException e) {
			ChatClient.log("error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					// 여기가 그냥 suddenly server 종료 했을 때
					socket.close();
					ChatClient.log("Server에 의해 강제 종료 당했습니다.");
					System.exit(1);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
