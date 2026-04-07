package ex3_generic;

public class Main {
	public static void main(String[] args) {
		
		// 문자열
		GenEx<String> v1 = new GenEx<String>();
		
		v1.setValue("java");
		System.out.println(v1.getValue());
		
		// 정수
		GenEx<Integer> v2 = new GenEx<Integer>();
		
		v2.setValue(100);
		System.out.println(v2.getValue());

		// 문자형
		GenEx<Character> v3 = new GenEx<Character>();
		
		v3.setValue('A');
		System.out.println(v3.getValue());
	
		//////
		
		Sample<String> sample = new Sample<String>();
		sample.addElement("This is String", 5);
		System.out.println(sample.getElement(5));
		
		///
		/// 
		
		Printer p = new Printer();
		
		// 1. 타입 추론
		// 제네릭 메서드를 호출할 때 전달한 값으로 타입을 자동 판단한다.
		p.printValue("안녕하세요");
		p.printValue(100);
		p.printValue(3.14);
		
		// 2. 명시적으로 타입을 적는 방법
		p.<String>printValue("안녕");
		p.<Integer>printValue(100);
		p.<Double>printValue(3.14);
		
		// 3. get 사용
		System.out.println(p.getValue("자바"));
		System.out.println(p.getValue(1000));
		
	}
}
