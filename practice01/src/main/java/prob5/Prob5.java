package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=1;i<=99;i++) {
			String k = "";
			k += i;
			for(int j=0;j<k.length();j++) {
				if(k.charAt(j)-'0'==3 || k.charAt(j)-'0'==6 || k.charAt(j)-'0'==9) {
					System.out.println(k+" 짝");
					break;
				}
			}
		}
		
	}
}
