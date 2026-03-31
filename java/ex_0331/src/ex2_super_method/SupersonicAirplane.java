package ex2_super_method;

public class SupersonicAirplane extends Airplane {
	
	//상수 선언
		static final int NORMAL = 1;
		static final int SUPERSONIC = 2;
		//상태 필드 선언
		int flyMode = NORMAL;

		//메소드 재정의
		@Override
		public void fly() {
			if(flyMode == SUPERSONIC) {
				System.out.println("초음속 비행합니다.");
			} else {
				super.fly(); // 부모의 메서드 호출
		}
	}
}
