package ex7_Example_02;

public class HybridWaterCar extends HybridCar {

	int waterGauge;
	
	public HybridWaterCar(int gasGauge, int electricGauge, int waterGauge) {
		super(gasGauge, electricGauge); // 부모(HybridCar) 생성자 호출
		this.waterGauge = waterGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		super.showCurrentGauge();	// 부모의 가스, 전기 출력 기능 재사용
		System.out.println("잔여 물량 : " + waterGauge);
	}
}
