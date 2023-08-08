package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		System.out.print("수를 입력하시요 : ");
		int x = scanner.nextInt();
		
		if(x%3==0) {
			System.out.println("3의 배수입니다.");
		}
	
		scanner.close();
	}
}

