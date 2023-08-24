package chattest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread{
	
	List<ChatUser> listUsers;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private ChatUser user;
	
	public ChatServerThread(Socket socket, List<ChatUser> listUsers) {
		this.socket = socket;
		this.listUsers = listUsers;
	}

	@Override
	public void run() {
		String remoteHostAddress = null;
		int remotePort = 0;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			remotePort = remoteInetSocketAddress.getPort();
			ChatServer.log("Connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			while (true) {
				String request = br.readLine();

				if (request == null) {
					ChatServer.log("클라이언트로부터 연결 끊김1");
					doQuit(user);
					break;
				}

				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1]);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					ChatServer.log("Disconnected by client[" + remoteHostAddress + ":" + remotePort + "]");
					doQuit(user);
					break;
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}
		} catch (SocketException e) {
			doQuit(user);
			ChatServer.log("Suddenly closed by client[" + remoteHostAddress + ":" + remotePort + "]");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void doQuit(ChatUser user) {
		removeUser(user);
		broadcast(user.getNickname() + "님이 퇴장 하였습니다.");
	}

	private void removeUser(ChatUser user) {
		synchronized(listUsers) {
			listUsers.remove(user);
		}
	}

	private void doMessage(String message) {
		broadcast(message);
	}

	private void doJoin(String nickname) {
		
		for(ChatUser user : listUsers) {
			if (nickname.equals(user.getNickname())) {
				pw.println("rejoin");
				return;
			}
		}
		
		user = new ChatUser(nickname, pw, br);
		broadcast(user.getNickname() + "님이 참여하였습니다!");
		addUser(user);
		pw.println("done");
	}
	
	private void broadcast(String data) {
	   synchronized(listUsers) {
	      for(ChatUser listuser : listUsers) {
	    	  if(!listuser.equals(user)) {
	    		  listuser.pwPrint(user.getNickname(),data);
	    	  }
	      }
	   }
	}

	private void addUser(ChatUser user) {
		synchronized(listUsers) {
			listUsers.add(user);
		}
	}
}
