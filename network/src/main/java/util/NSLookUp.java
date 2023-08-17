package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookUp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println(">> ");
			String line = scanner.nextLine();
			
			if(line.equals("quit")) {
				break;
			}
			
			try {
				InetAddress[] Addresses = InetAddress.getAllByName(line);
				for(InetAddress k : Addresses) {
					System.out.println(k);
				}
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			// inetAdress static getallbyname(string host)
			
		}
	}

}
