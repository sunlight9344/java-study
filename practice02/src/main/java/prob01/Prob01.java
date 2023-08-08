package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액: ");
		int x = scanner.nextInt();
		int cnt = 0;
		while(true) {
			if(x==0) {
				break;
			}
			
			int k = x / MONEYS[cnt];
			if(k>0) {
				System.out.println(MONEYS[cnt]+"원 : " + k + "개");
				x -= MONEYS[cnt]*k;
			}
			cnt += 1;
		}
 	}
}