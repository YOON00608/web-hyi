package ex4_setter_getter;

public class StudentMain {
	public static void main(String[] args) {
		
		// 학생 객체를 만든 후 값을 세팅하고 출력하기
		Student s1 = new Student();
		
		s1.setAge(-10);
		s1.setName("김자바");
		
		System.out.println("나이 : " + s1.getAge());
		System.out.println("이름 : " + s1.getName());
		
		
	}
}
