package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods camera = new Goods();
		camera.setName("Nikon");
		camera.setPrice(400000);
		camera.setCountSold(40);
		camera.setCountStock(50);
		
		// 정보은닉(데이터보호)
		//camera.setPrice(-1);
		
		for(int i=0;i<10;i++) {
			System.out.println(Goods.countOfGoods);
			new Goods();
		}
		
		camera.showInfo();
		int discountPrice = camera.calDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		Goods tv = new Goods("TV",999999,10,1);
		tv.showInfo();
		
	}
	
}
