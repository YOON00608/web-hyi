package ex5_polymorphism.exam04;

public class Main {
	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		
		zoo.printSound(new Dog());
		zoo.printSound(new Cat());
	}
}
