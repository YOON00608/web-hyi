package ex2_interface;

// 리모컨에 대한 가이드라인(인터페이스)
public interface RemoteControl {
	
	// public static final 을 생략해도 상수 취급을 한다.
	//상수 필드
		int MAX_VOLUME = 10;
		int MIN_VOLUME = 0;

		//추상 메소드
		void turnOn();
		void turnOff();
		void setVolume(int volume);

		//디폴트 인스턴스 메소드
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("무음 처리합니다.");
				//추상 메소드 호출하면서 상수 필드 사용
				setVolume(MIN_VOLUME);
			} else {
				System.out.println("무음 해제합니다.");
			}
		}
	
	// 정적메서드
	// static 메서드는 구현 객체가 없어도 인터페이스만으로 호출할 수 있다.
	static void changeBattery() {
		System.out.println("리모컨 건전지를 교체합니다.");
	}
	
	// private 메서드
	// 인터페이스 외부에서는 접근할 수 없는 메서드
	private void config() {
		System.out.println("설정모드로 접근");
	}
	
	
}
