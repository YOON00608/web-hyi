package ex6_inheritance.example;

public class FountainPen extends BallPen {	
	
	public FountainPen (int amount, String color) {
		super(color, amount);
	}
	
	public void refill(int n) {
		setAmount(n);
		System.out.println(getColor()+"색 만년필을 " + n + "만큼 리필했습니다.");
	}
}
