package ex1_datatype;

public class Ex2_FloatDoubleExample {
	public static void main(String[] args) {
		// 리터럴 : 변수에 저장하기 위한 값 자체. 문자 자체.
		
		// 실수 리터럴 값은 기본타입으로 double로 취급한다.
		// 숫자 뒤에 f를 붙여 해당 값이 float타입이라는 것을 명시한다.
		
		// 정밀도 확인
		float f1 = 0.1234567890123456789f;
		double d1 = 0.1234567890123456789;
		
		System.out.println("float : " + f1); // float : 0.12345679
		System.out.println("double : " + d1); // double : 0.12345678901234568
		// double 타입이 정밀한 작업을 할 때 유용한다.
		
		// 10의 거듭제곱 리터럴
		double d2  = 3e6; // 3 x 10^6
		float  f2 = 3e6f; // 3 x 10^6
		double d3 = 2e-3; // 2 x 10^-3
		
		System.out.println("d2 : " + d2); // 3000000.0
		System.out.println("f2 : " + f2); // 3000000.0
		System.out.println("d3 : " + d3); // 0.002
		
	}
}
