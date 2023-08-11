package prob6;

public class RectTriangle extends Shape {
	
	private double width;
	private double height;

	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	protected String getArea() {
		return String.valueOf(width*height*1/2);
	}

	@Override
	protected String getPerimeter() {
		return String.valueOf(
				width + height +
				Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2))
				);
	}

}
