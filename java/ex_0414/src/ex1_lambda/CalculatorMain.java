package ex1_lambda;

public class CalculatorMain {
	public static void main(String[] args) {
		
		CalculatorService cs = new CalculatorService();
		
		Calculator c = (a,b) -> a + b;
		cs.execute(c); // 결과 : 30
		
		cs.execute((a,b) -> a-b); // 직접 써도 가능, 결과 : -10
		
		
	}
}
