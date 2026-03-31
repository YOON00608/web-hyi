package ex1_overriding;

public class AnimalMain {
	
	public static void main(String[] args) {
		
		Anima animal = new Anima();
		animal.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		
		
	}
}
