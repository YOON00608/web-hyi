package ex6_inheritance.example;

public class FountainPen extends BallPen {	
	public FountainPen (int amount, String color) {
		super();
	}
	
	public void refill(int n) {
		this.amount = n;
		System.out.println("잉크를 " + n + "만큼 충전했습니다.");
	}
}
