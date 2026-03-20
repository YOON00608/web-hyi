package ex_variable;

public class Ex2_VariableExchange {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		
		System.out.println(x);
		System.out.println(y);
		// 변수 x에 들어있는 값과 변수 y에 들어있는 값을 교환
		// 필요하다면 변수를 또 만들어도 됨.
		
		int z;
		z = x;
		x = y;
		y = z;
		
		System.out.println("x : " + x);	// x : 5
		System.out.println("y : " + y); // y : 3
		
		//------------------------------------------------
		
		
	}
}
