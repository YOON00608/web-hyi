package ex5_Operator;

public class Ex3_CheckExample {
	public static void main(String[] args) {
		
		int x = 5;
		double y = 0.0;
		double z = x / y;
		System.out.println(Double.isInfinite(z)); // true = Infinity = 무한대
		
		z = x % y;
		System.out.println(Double.isNaN(z)); // true = NaN = Not A Number
	}
}
