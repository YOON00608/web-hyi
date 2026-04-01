package ex1_abstract.Example.AllExample;

public class AirPlane extends Transport {
	
	int airportFee; // 공항 이용료
	int fuelCharge; // 유류할증비
	
	// 기본요금 + 공항 이용료 + 유쥬할증비
	public AirPlane(String name, int baseFare,int airportFee,int fuelCharge) {
		super(name, baseFare);
		this.airportFee = airportFee;
		this.fuelCharge = fuelCharge;
	}

	@Override
	public int calculatorFare() {
		return baseFare + airportFee + fuelCharge;
	}
	
	
	
	
}
