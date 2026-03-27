package ex2_method;

public class CalculatorMain {
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		int result = c.getResult(1, 2, "/");
		System.out.println("값 : " + result); // 대입 출력
		
		System.out.println(c.getResult(1, 2, "(")); // 바로 출력

	}
}
