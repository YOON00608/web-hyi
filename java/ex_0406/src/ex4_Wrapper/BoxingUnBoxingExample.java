package ex4_Wrapper;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		
		// Boxing
		Integer obj = 100;
		System.out.println("value : " + obj.intValue()); // value : 100
		
		// Unboxing
		int result = obj;
		System.out.println("result : " + result); // result : 100--
	}
}
