package ex5_Operator;

public class Ex2_DoubleOperatorExample {
	public static void main(String[] args) {
		// 산술연산자:
		// +,-,*,/,%
		
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		int result1 = v1 + v2; // 모든 피연산자는 int로 변환
		System.out.println("result1: " + result1);
		
		long result2 = v1 + v2 - v4; // 모든 피연산자는 long으로 변환
		System.out.println("result2: " + result2);
		
		double result3 = v1 / v3; 
		System.out.println("result3: " + result3); // 2.0
		
		int result4 = v1 % v2;
		System.out.println("result4: " + result4); // 나머지 2
		
		// ------------------------------------
		
		// 산술변환
		// 기본적으로 이항 연산자의 연산은 두 피연산자의 타입이 일치해야 가능하다.
		// 컴퓨터는 서로 다른 타입을 계산하지 못하므로 값의 손실이
		// 적은쪽으로 타입이 맞춰진다.
	
		
		
	}
}
