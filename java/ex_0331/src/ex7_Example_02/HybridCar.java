package ex7_Example_02;

public class HybridCar extends Car {
	int  electricGauge;
	
	public void electricGauge(int gasGauge,int electricGauge) {
		this.electricGauge = electricGauge;
	}
	
	@Override
	public void showCurrentGauge() {
		System.out.println(electricGauge);
	}
	
}
