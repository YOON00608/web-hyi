package ex1_abstract.Example.AllExample;

public class Taxi extends Transport {
	
	int distance; // 거리
	int farePerKm; // 거리당 요금
	
	// Transport의 생성자를 super로 받는다.
	// 필드에 자식생성자를 추가한다.
	public Taxi(String name, int baseFare, int distance, int farePerKm) {
		super(name, baseFare);
		this.distance = distance;
		this.farePerKm = farePerKm;
	}
	
	@Override
	public int calculatorFare() {
		return baseFare + (distance * farePerKm); // 기본요금에 거리*거리당 요금
	}
}
