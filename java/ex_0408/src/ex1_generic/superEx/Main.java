package ex1_generic.superEx;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	// List<? super Dog>list 에서 허용되는 타입 : 
	// List<Dog>, List<Animal>, List<Object>
	// List<Puppy> 는 안 됨
	public static void addDog(List<? super Dog>list) {
		list.add(new Dog());
		list.add(new Puppy()); // Puppy 객체는 Dog 로 취급한다.
	}
	
	public static void main(String[] args) {
		List<Animal> animalList = new ArrayList<>();
		List<Dog> dogList = new ArrayList<>();
		List<Puppy> puppyList = new ArrayList<>();
		
		addDog(animalList);
		addDog(dogList);
		// addDog(puppyList); 불가능. Dog의 자식 클래스이기 때문이다.
		
		// 각 리스트에 들어있는 객체의 메서드 호출하기
		for(Animal a : animalList) {
			a.speak();
		}
		
		for(Dog d : dogList) {
			d.speak();
		}
	}
}
