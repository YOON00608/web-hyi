package ex2_interface;

public class Main {
	
	public static void main(String[] args) {
	
		//인터페이스 변수 선언
				RemoteControl rc;

				//Television 객체를 생성하고 인터페이스 변수에 대입
				rc = new Television();
				rc.turnOn();
				rc.setVolume(5);

				//디폴트 메소드 호출
				rc.setMute(true);
				rc.setMute(false);
				
				RemoteControl.changeBattery();
				
				// 해당 인터페이스에서 구현한 메서드만 사용이 가능하다.
				// rc.search("dcasc.com"); -> x
				
				Searchable searchable = new SmartTelevision();
				searchable.search("https://www.youtube.com");
				
				SmartTelevision st = new SmartTelevision();
				st.turnOff();
				st.turnOn();
		}
}
