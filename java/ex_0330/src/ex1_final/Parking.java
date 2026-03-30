package ex1_final;

public class Parking {

	// 기본요금 : 10,000원 (상수)
	// 추가 요금 : 시간당 2,000원 (상수)
	
	static final int BADE_FARE = 10000;
	static final int EXTRA_CHARGE = 2000;
	
	// 요금 계산 메서드
	
	static public int calculateFee(int time) {
		return BADE_FARE + (EXTRA_CHARGE * time);
	};  
	
}
