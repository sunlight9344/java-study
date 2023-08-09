package chapter03;

import mypackage.Goods2;

public class Goods2App{

	public static void main(String[] args) {
		Goods2 good = new Goods2();
		
		//public
		good.name = "he";
		
		//protected(오류)
		//good.price = 9999999;
		
		//default(오류)
		//good.countStock = 20;

	}
}
