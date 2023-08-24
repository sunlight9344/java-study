package chattest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<ChatUser> listUsers = new ArrayList<ChatUser>();
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind( new InetSocketAddress("0.0.0.0", PORT ) );			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			log( "Waiting for connect... " + hostAddress + ":" + PORT );
			while(true) {
				   Socket socket = serverSocket.accept();
				   new ChatServerThread(socket,listUsers).start();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void log(String message) {
		System.out.println("[ChatServer#" + Thread.currentThread().getId()+"] " + message);
	}
}
