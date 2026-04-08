package ex1_generic.calculatorExample;

public class CalculatorMain {
	
	// 제네릭에 타입을 넣을 수 있는 건 좋은데
	// 아무 타입이나 넣어도 된다는 게 문제이다.
	Calculator<Number> cal1 = new Calculator<>();
	Calculator<Integer> cal2 = new Calculator<>();
	Calculator<Double> cal3 = new Calculator<>();
	Calculator<Long> cal4 = new Calculator<>();
	
	// 어떤 기능을 만들 때는
	// 특정 성질을 가진 타입만 받아야 안전하다는 문제가 생긴다.
	
	// 제네릭에 넣을 수 있는 타입의 범위를 한정
	
	// 1. 잘못된 타입을 미리 막을 수 있다.
	// 2. 상위 타입의 기능을 사용할 수 있다.
}
