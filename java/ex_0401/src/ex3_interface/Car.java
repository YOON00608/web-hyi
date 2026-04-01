package ex3_interface;

public class Car {
	
		Tire tire1;
		Tire tire2;
		
		void run() { //인터페이스에 선언된 추상 메소드 호출 -> 구현 객체의 roll()메소드 실행
			tire1.roll();
			tire2.roll();
		}
		
	
}
