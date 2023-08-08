package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		
		
		while(true) {
			System.out.print("숫자를 입력하세요: ");
			int x = scanner.nextInt();
			int result = 0;
			if(x%2==0) {
				for(int i=0;i<=x;i++) {
					if(i%2==0) {
						result += i;
					}
				}
			}else {
				for(int i=0;i<=x;i++) {
					if(i%2==1) {
						result += i;
					}
				}
			}
			System.out.println("결과 값 : "+result);
			System.out.println();
		}
	}
}
