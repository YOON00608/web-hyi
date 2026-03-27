package ex2_method;

public class Ex2_MethodMain {
	public static void main(String[] args) {
		
		// 1. 객체가 정의 되어야 한다.
		Ex1_MethodExample m = new Ex1_MethodExample();
		
		// 2. 객체를 통해서 메서드를 호출해야 한다.
		// 변수명.메서드명();
		m.printInfo();
		
		// 두 수를 더하여 반환하는 add 메서드 작성하기
		
		// 메서드의 호출
		int result = m.add(3, 2);
		System.out.println(result); // 1. 변수에 저장하고서 출력
		
		System.out.println(m.add(2, 3)); // 2. 바로 출력
		
		System.out.println(m.cirecleArea(10)); // 314.0 
		
		m.cirecleRound(5);
		
		int arr [] = {1,2,3,4};
		int result2 = m.countEven(arr);
		System.out.println(result2);
		
		int result3 = m.countChar("apple", 'p');
		System.out.println("p의 개수 : " + result3);
		
	}
}
