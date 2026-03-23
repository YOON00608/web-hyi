package ex5_Operator;

public class Ex1_SignOperatorExample {
	public static void main(String[] args) {
		
		// 부호를 결정하는 연산자
		int x = -100; // - : 연산자 , 100 : 피연산자
		x = -x;
		System.out.println("x의 값 : " + x); // 100
		
		// 증감연산자:
		// 1씩 증가시키거나 1씩 감소시키는 연산자
		
		// ++ : 1을 증가
		// -- : 1을 감소
		
		// 전위연산: 연산자가 앞에 오는 연산
		int a = 5;
		System.out.println(++a); // 6
		// 후위연산 : 연산자가 피연산자 뒤에 오는 연산
		// 사용을 먼저 하고 연산이 나중에 이루어진다.
		int b = 5;
		System.out.println(b++); // 5 < 여기서 사용을 함.
		System.out.println(b); // 6 < 사용을 했으니까 더함.
		
		// 변수할 때 대입을 해야 저장이 된다면서?
		// 증감연산자 ++x -> x + 1;
		x= 5;
		int result = ++x + x++;
		System.out.println(result); // 12 -> 얘는 연산을 한 거임.
		System.out.println(x); // 7 -> 얘는 연산에 사용된 x에 이어서 수를 더한 거.
		
		x = 2;
		int y = 3;
		int z = x++ + ++y; // 얘는 x랑 y랑 달라서 y가 1대입이 안 된거임.
		// x, y, z의 값을 구하세요
		// x:3 y:4 z:6
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		// ----------------------------------------
		
		// 논리 부정 연산자
		// !논리형 데이터
		
		// true -> false
		// false -> true
		
		boolean isOn = true;
		System.out.println(!isOn); // false
		
	}
}
