package T_0405.succession2;

public class Computer extends Calculator {
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 실행");
		return Math.PI * r * r;
	}
}
