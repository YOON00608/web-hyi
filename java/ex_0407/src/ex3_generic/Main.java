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
		
		
		
		
		
	}
}
