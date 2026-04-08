package ex3_generic.exam;

public class Main {
	public static void main(String[] args) {
		
		ArrayPrinter ap = new ArrayPrinter();
		
		String[]names = {"김철수","이영희","박민수"};
		// 타입추론
		// 인자로 전달한 값의 타입을 제네릭에 자동으로 전달
		ap.printArray(names);
		
		// 타입명시
		Integer[] nums = {10,20,30};
		ap.<Integer>printArray(nums);
		
	}
}
