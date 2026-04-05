package T_0405.succession2;

public class AnimalMain {
	public static void main(String[] args) {
		
		//Animal[] arr = {new Dog(), new Cat()};
		//for(Animal a : arr) {
		//	a.sound();
		//}
		
		Animal a = new Dog();
		Dog d = (Dog) a;
		d.sound();
		
		
	}
}
