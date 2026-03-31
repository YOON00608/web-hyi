package ex5_polymorphism.exam04;


// 추상클래스를 상속받은 클래스는 추상 메서드를 반드시
// 오버라이딩해서 내용을 구현해야 한다.
public class Dog extends Animal {
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}
