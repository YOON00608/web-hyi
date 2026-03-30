package ex4_constructor;

public class PersonMain {
	public static void main(String[] args) {
		
		// 기본생성자랑 같이 쓸 수가 없다.
		// 매개변수가 정해져 있으면
		// 호출할 때 값을 꼭 전달해야 한다. 
		Person p1 = new Person("김자바",27);
		p1.introduce();
	}
}
