package prob6;

public class Rectangle extends Shape implements Resizable{

	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	protected String getArea() {
		return String.valueOf(width*height);
	}

	@Override
	protected String getPerimeter() {
		return String.valueOf((width+height)*2);
	}

	@Override
	public void resize(double d) {
		width *= d;
		height *= d;
	}

}
