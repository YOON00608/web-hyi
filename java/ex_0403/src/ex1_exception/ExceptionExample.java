package ex1_exception;

public class ExceptionExample {
	
	// NullPointerException
	// 참조변수에 null이 들어가 있는데 필드나 메서드를 사용하려고 할 때 발생하는 예외
	public static void main(String[] args) {
		int[] array = null;
		System.out.println(array[0]);
	}
	
	
}
