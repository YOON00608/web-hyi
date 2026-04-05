package T_0405;

public class Main {
	public static void main(String[] args) {
		
		Animal[] arr = {new Dog(), new Cat()};
		for(Animal a : arr) {
			a.sound();
		}
	}
}
