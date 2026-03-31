package ex7_Example_02;

public class HybridCar extends Car {
	
	int  electricGauge;
	
	public HybridCar(int gasGauge, int electricGauge) {
		super(gasGauge); // 부모 생성자 호출
		this.electricGauge = electricGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		super.showCurrentGauge(); // 부모의 가스 출력 기능 재사용
		System.out.println("잔여 전기량 : " + electricGauge);
	}
}
