package ex2_super_method;

public class Main {
	public static void main(String[] args) {
		
		// 초음속 비행기 객체 생성하기
		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		
		sa.land();
	}
}
