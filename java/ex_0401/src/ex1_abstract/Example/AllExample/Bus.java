package ex1_abstract.Example.AllExample;

public class Bus extends Transport {
	
	// Transport의 생성자를 super로 받는다.
	public Bus(String name, int baseFare) {
		super(name, baseFare);
	}
	
	// 기본요금 반환
	@Override
	public int calculatorFare() {
		return baseFare;
	}
}
