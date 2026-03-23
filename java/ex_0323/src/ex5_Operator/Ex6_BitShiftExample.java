package ex5_Operator;

public class Ex6_BitShiftExample {
	public static void main(String[] args) {
		int num1 = 1; // 0001
		int result1 = num1 << 3;
		int result2 = num1 * (int)Math.pow(2, 3); // 8
		System.out.println("result1 : " + result1); // 8
		
		int num2 = -8; // 00001000 -> 11110111 -> 11111000 
		int result3 =  num2 >> 3;
		System.out.println("result3 : " + result3); // -1
	}
}
