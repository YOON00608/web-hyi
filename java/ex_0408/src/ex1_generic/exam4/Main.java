package ex1_generic.exam4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		AnimalPrint animal = new AnimalPrint();
		
		List<Dog> dogs = new ArrayList<>();
		List<Cat> cats = new ArrayList<>();
		
		animal.printAnimals(dogs);
		animal.printAnimals(cats);
	}
}
