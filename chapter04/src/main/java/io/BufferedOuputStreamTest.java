package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOuputStreamTest {

	public static void main(String[] args) {
		
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림
			FileOutputStream fis = new FileOutputStream("hello.txt");
			
			// 보조 스트림
			bos = new BufferedOutputStream(fis);
			
			for(int i='a';i<='z';i++) {
				bos.write(i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: "+e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
				bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
