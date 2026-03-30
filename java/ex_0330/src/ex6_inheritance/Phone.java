package ex6_inheritance;

// 상속 해주는 클래스(부모 클래스, 슈퍼 클래스 등등)
// 자식 클래스에게 필드, 메서드를 사용할 수 있도록 제공한다.
public class Phone {
	
	// 필드
	public String model;
	public String color;
	
	// 메서드
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendMessage(String message) {
		System.out.println("나 : " + message);
	}

	public void receiveMessage(String message) {
		System.out.println("상대방 : " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
	
}
