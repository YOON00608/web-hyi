package ex1_abstract.Example.AllExample;

public abstract class Transport {
	
	String name;
	int baseFare;
	
	// 부모의 생성자
	public Transport(String name,int baseFare) {
		this.name = name;
		this.baseFare = baseFare;
	}
	
	// void showName() : "교통수단: 버스"
	public void showName() {
		System.out.println("교통수단 : " + name);
	}
	
	// void printFare(int distance)
	public void printFare(int distance) {
		showName(); // showName()을 호출
		System.out.println("거리 : " + distance + "km"); // 거리를 출력
		System.out.println("총 요금 : " + calculatorFare() + "원"); // 요금 계산 : "총 요금 xx원" 형식으로 출력
		System.out.println(); // 각 교통수단의 결과 출력 뒤에는 한 줄을 띄우시오.
	}

		public abstract int calculatorFare(); // 추상메서드
}
