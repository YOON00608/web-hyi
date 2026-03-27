package ex4_constructor;

public class PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person("김자바",27);
		// 기본생성자랑 같이 쓸 수가 없다.
		p1.introduce();
	}
}
