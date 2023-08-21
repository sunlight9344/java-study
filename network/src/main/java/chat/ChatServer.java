package chat;

import java.io.IOException;
import java.io.Writer;
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
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind( new InetSocketAddress("0.0.0.0", PORT ) );			

			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			log( "연결 기다림 " + hostAddress + ":" + PORT );
			while( true ) {
				   Socket socket = serverSocket.accept();
				   new ChatServerThread(socket,listWriters).start();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void log(String message) {
		System.out.println("[ChatServer#" + Thread.currentThread().getId()+"] " + message);
	}
}
