package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneTest02 {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("phone.txt");
		
		
		if(!file.exists()) {
			System.out.println("File Not Found");
			return;
		}
		
		System.out.println("===== 파일정보 =====");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());

		System.out.println(
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()))
		);
		
		System.out.println("===== 전화번호 =====");
		
		
		
		
		
		
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String name = scanner.next();
			String p1 = scanner.next();
			String p2 = scanner.next();
			String p3 = scanner.next();
			System.out.println(name+":"+p1+"-"+p2+"-"+p3);
		}
		scanner.close();
	}

}
