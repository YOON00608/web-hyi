package ex6_inheritance.example;

public class BallPen extends Pen {
	
	private String color;
	
	public BallPen(String color, int amount) {
		super(amount);
		this.color = color;
	}	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
