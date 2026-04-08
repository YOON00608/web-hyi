package ex1_generic.exam4;

import java.util.List;

public class AnimalPrint {
	
	public void printAnimals(List<? extends Animal> list) {
		for(Animal animal : list) {
			System.out.println(animal);
		}
	}
}
