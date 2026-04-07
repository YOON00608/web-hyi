package ex3_generic;

// 제네릭 클래스 안에 제네릭 메서드가 있을 수도 있다.
public class Printer<U> {
	
	private U value;
	
	public void printAnother(U data) {
		System.out.println("value의 값 : " + value);
	}
	
	// 클래스 제네릭 타입과 제네릭 메서드 타입이 같으면
	// 제네릭 메서드의 타입이 우선 적용 된다.
	public <T> void printValue(T value) {
		System.out.println(value);
	}
	
	public <T> T getValue(T value) {
		return value;
	}
	
}
