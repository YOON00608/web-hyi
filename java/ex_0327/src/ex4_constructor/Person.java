package ex4_constructor;

public class Person {
	
	// 필드
	String name;
	int age;
	
	// 생성자(정의)
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 메서드(정의)
	public void introduce() {
		System.out.printf("안녕하세요. 저는 %d살 %s입니다.", age,name);
	}
		
	
	
}
