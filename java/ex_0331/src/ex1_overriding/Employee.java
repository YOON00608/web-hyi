package ex1_overriding;

import ex6_sealed.Person;

public class Employee extends Person {
	String name;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public int getPay() {
		return 0;
	}
}
