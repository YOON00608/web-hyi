package ex7_Example_02;

public class Car {
	
	int gasGauge;
	
	public Car(int gasGauge) {
		this.gasGauge = gasGauge;
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가스량 : " + gasGauge);
	}
}
