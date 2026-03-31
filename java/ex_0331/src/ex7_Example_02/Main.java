package ex7_Example_02;

public class Main {
	
	public static void main(String[] args) {
		
		HybridWaterCar w = new HybridWaterCar();
		
		w.electricGauge(15,30);
		w.waterGauge(15,30,25);
		
		System.out.println(w.showCurrentGauge());
		
		
		
	
	
	
	}
}
