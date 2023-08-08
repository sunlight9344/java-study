package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.print("숫자를 입력하세요: ");
			int x = scanner.nextInt();
			
			if(x%2==0) {
				System.out.println(Math.pow(x/2, 2)+x/2);
			}else {
				System.out.println(Math.pow(x/2, 2));
			}
		}
		
	}
	
}
