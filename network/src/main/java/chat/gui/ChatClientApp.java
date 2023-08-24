package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		while( true ) {
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
		
			if (name.isEmpty() == false ) {
				break;
			}
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		//1. create socket
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			System.out.print("닉네임을 입력해주세요! >>");
			String nickname;
			String response;
			
			while(true) {
				nickname = scanner.nextLine();
				pw.println("join:" + nickname);
				response = br.readLine();
				if("done".equals(response)) {
					break;
				}
				System.out.println("중복된 닉네임입니다. 다시 입력 ㄱㄱ");
				System.out.print(">>");
			}
			System.out.println("채팅방에 입장하였습니다!");
			
			new ChatWindow(name,socket).show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2. connect server
		//3. join protocol 진행
	}
}