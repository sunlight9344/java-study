package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	
	private float discountRate = 0.5f;
	
	public int getDiscountPrice() {
		int discountPrice = (int)(discountRate * price);
		return discountPrice;
	}
	
}
