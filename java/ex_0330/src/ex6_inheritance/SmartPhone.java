package ex6_inheritance;

// 상속을 받는 쪽이 상속을 하는 쪽을 선택한다.
// extends 키워드를 통해 상속받을 클래스를 선택한다.

// 상속 받는 클래스(자식 클래스, 파생 클래스 등등)
public class SmartPhone extends Phone {

	// 필드
	public boolean wifi;
	
	// 생성자 생성
	public SmartPhone(String model, String color) {
		// 부모가 가지고 있는 필드를 자식 클래스에서 사용할 수 있다.
		this.model = model;
		this.color = color;
	}
	
	// 메서드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
}
