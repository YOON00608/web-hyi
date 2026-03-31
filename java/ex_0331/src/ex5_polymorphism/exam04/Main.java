package ex5_polymorphism.exam04;

public class Main {
	public static void main(String[] args) {
		
		// 추상클래스는 객체를 직접 생성할 수 없다.
		Zoo zoo = new Zoo();
		
		zoo.printSound(new Dog());
		zoo.printSound(new Cat());
	}
}
