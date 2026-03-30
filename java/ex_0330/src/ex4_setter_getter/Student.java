package ex4_setter_getter;

public class Student {
	
	// 필드
	// 문자열 타입의 이름
	// 정수 타입의 나이
	
	private String name;
	private int age;
	
	// 모든 필드는 private 로 선언
	// setter / getter 를 각각 구현
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		} else {System.out.println("잘못된 나이입니다.");
	}
	}
	
	/////////
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
		
	
	 
	
}
