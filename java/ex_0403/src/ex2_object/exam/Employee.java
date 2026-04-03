package ex2_object.exam;

public class Employee {
	String name;
	String dept;
	
	public Employee(String name, String dept) {
		this.dept = dept;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + "," + dept;
	}
	
}
