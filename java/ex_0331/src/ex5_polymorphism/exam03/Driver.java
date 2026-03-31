package ex5_polymorphism.exam03;

// 운전자
public class Driver {
	
	// 매개변수로 부모타입의 변수를 넣는다.
	public void driver(Vehicle vehicle) {
		vehicle.run();
	}
	
	
	
}
