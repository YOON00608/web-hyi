package ex3_generic.exam;

public class ArrayPrinter<T> {
	// 배열을 외부에서 전달 받아 화면에 출력하는 기능을 가진
	// printArray 제네릭 메서드 작성하기
	
	// Main 에서 다음의 배열들을 출력하기
	// String [] name = {"김철수","이영희","박민수"};
	// Integer[] nums = {10,20,30};
	
	public static void main(String[] args) {
		
		String [] name = {"김철수","이영희","박민수"};
		Integer [] nums = {20,30,40};
		
		PrintArray(name);
		PrintArray(nums);
	
	}
		
		public static <T> void PrintArray(T[] arr) {
			for(int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		
	}
}
