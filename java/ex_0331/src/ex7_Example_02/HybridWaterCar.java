package ex7_Example_02;

public class HybridWaterCar extends HybridCar {

	int waterGauge;
	
	public void waterGauge(int gasGauge, int electricGauge, int waterGauge) {
		this.waterGauge = waterGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		
	}
	
}
