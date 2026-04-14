package ex1_lambda;

public class CalculatorService {
	
	// 람다를 매개변수로 받는 메서드
	// 식 자체를 매개변수로 넘길 수 있다.
	public void execute(Calculator calculator) {
		int result = calculator.calc(10, 20);
		System.out.println("결과 : " + result);
	}
	
	// 람다를 반환하는 메서드
	
	
	
	
	
}
