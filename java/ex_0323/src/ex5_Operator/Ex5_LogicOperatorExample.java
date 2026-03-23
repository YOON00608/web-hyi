package ex5_Operator;

public class Ex5_LogicOperatorExample {
	public static void main(String[] args) {
		
		// && 
		// T && T -> T
		// T && F -> F
		// F && T -> F
		// F && F -> F
		int x = 10;
		int y = 5;
		
		boolean result = x >= 10 && y == 10;
		System.out.println(result); // false
		
		result = (x-y) >= 10 && (++y) == 5;
		// y의 값은 얼마일까?
		System.out.println(y); // 5. 앞이 false면 뒤는 연산하지 않음.
		
		// ||
		// T || T -> T
		// T || F -> T
		// F || T -> T
		// F || F -> F
		
		result = (x-y) <= 10 || (++y) == 5;
		System.out.println(y); // 5. 앞이 true면 뒤는 연산하지 않음.
		
		// 비트논리연산자
		// 기능은 논리연산자와 같지만, bit단위의 연산만 가능하다.
		// 피연산자가 1, 0이라는 것과 산출 결과가 1, 0이라는 점이 특징.
		// 1 : true, 0 : false 라고 생각하면 논리연산자와 차이는 없다.
		
		// & 논리곱 : 둘 다 1이면 1, 아니면 0
		// | 논리합 : 둘 중 하나라도 1이면 1, 아니면 0
		// ^ 배타적 논리합 : 두 항이 다르면 1, 같으면 0
		// ~ 부정 : 1을 0으로, 0을 1로 연산
		
		int a = 10; // 1010;
		int b = 7; // 0111;
		int c = a & b; // 2진수로 바꿨을 때 두 값이 모두 1이여만 1.
		System.out.println("c : " + c); // 2
		
		int a2 = 12; // 1100
		int b2 = 8;  // 1000
		int c2 = a2 | b2; // 1100
		System.out.println("c2 : " + c2); // 12
		
		int a3 = 9; // 1001
		int b3 = 11; // 1011
		int c3 = a3 ^ b3;
		System.out.println("c3 : " + c3); // 2
		
		// ~ 연산
		// 2진수는 음수를 표현할 수 없다.
		// 비트의 맨 앞자리는 부호의 표현으로 쓰기로 약속.
		int a4 = 7; // 0111 -> 1000 -> 1001
		System.out.println("~x : " + ~a4); // -8
		
	}
}
