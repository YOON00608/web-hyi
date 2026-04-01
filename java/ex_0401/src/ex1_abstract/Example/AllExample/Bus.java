package ex1_abstract.Example.AllExample;

public class Bus extends Transport {
	
	// Transport의 생성자를 super로 받는다.
	// 상속을 받으면 자식객체가 만들어질 때
	// 부모생성자가 먼저 호출이 된다.
	// 그래서 super()가 생략이 되어있는데
	// 부모생성자에 매개변수가 들어있으면 명시해줘야 한다.
	public Bus(String name, int baseFare) {
		super(name, baseFare);
	}
	
	// 기본요금 반환
	@Override
	public int calculatorFare() {
		return baseFare;
	}
}
