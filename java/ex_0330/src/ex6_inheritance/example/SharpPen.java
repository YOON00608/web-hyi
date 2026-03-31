package ex6_inheritance.example;

public class SharpPen extends Pen {
	
	private int width;
	
	public SharpPen(int width, int amount) {
		super(amount);
		this.width = width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
}
