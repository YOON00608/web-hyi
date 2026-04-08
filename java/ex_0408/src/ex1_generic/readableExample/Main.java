package ex1_generic.readableExample;

public class Main {
	public static void main(String[] args) {
		
		Box<BoxType> box = new Box<>();
		
		// 모든 클래스를 상속 받는 상위클래스여도,
		// Readable 과 Closeable 을 동시에 구현한 클래스만이 타입 할당이 가능하다.
		// Box<Object> box2 = new Box<>();	
	}
}
