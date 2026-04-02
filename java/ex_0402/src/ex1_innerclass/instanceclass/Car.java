package ex1_innerclass.instanceclass;

// 1. 클래스 내부에서만 쓰는 전용 객체
// - 외부에 공개할 필요가 없는 경우
public class Car {
	
	// 인스턴스 내부 클래스
	private class Engine{
		void start() {
			System.out.println("엔진 시동");
		}
	}
	
	// Engine 클래스는 Car 내부에서만 의미가 있다.
	// 외부에 노출할 필요가 없다.
	void run() {
		Engine engine = new Engine();
		engine.start();
	}
}
