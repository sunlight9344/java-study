package prob02;

public class Goods {
	
	private String name;
	private int price;
	private int count;
	
	public Goods(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}
	
	
}
