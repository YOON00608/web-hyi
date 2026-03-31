package ex5_polymorphism.exam01;

public class CarMain {
	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		// Tire 객체 장착       
		myCar.tire = new Tire();
		myCar.speed = 100;
		myCar.brand = "포르쉐";
		myCar.run(); // 회전합니다.

		// 한국타이어로 타이어 교체
		
		myCar.tire = new HankookTire();
		myCar.run(); // 한국 타이어가 회전합니다.
		
		// 금호타이어로 타이어 교체
		
		myCar.tire = new KumhoTire();
		myCar.run(); // 금호 타이어가 회전합니다.
		
	}
}
