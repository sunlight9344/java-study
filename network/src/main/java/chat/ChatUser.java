package chat;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class ChatUser {

	private BufferedReader br;
	private PrintWriter pw;
	private String nickname;
	
	public ChatUser(String nickname,PrintWriter pw,BufferedReader br) {
		this.br = br;
		this.pw = pw;
		this.nickname = nickname;
	}
	
	public void pwPrint(String sayUserName,String data) {
		pw.println(sayUserName +" << " + data);
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
