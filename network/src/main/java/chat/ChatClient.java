package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;


public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			socket = new Socket();
			scanner = new Scanner(System.in);
			
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			
			new ChatClientThread(socket).start();
			
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				if ("quit".equals(input)) {
					pw.println("quit");
					break;
				}
				if(input.equals(null)) {
					break;
				}
				pw.println("message:"+input);
			}
		} catch (SocketException e) {
			System.out.println("[client] suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[client] error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	static void log(String message) {
		System.out.println("[ChatClient#" + Thread.currentThread().getId()+"] " + message);
	}
}
