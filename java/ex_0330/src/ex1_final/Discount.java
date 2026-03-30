package ex1_final;

public class Discount {
	
	static final double RATE_HIGHT = 0.2;
	static final double RATE_MID = 0.1;
	static final double RATE_LOW = 0.05;
	
	// 금액에 따라서 할인률을 결정하는 disCountRate 메서드 만들기
	// 금액이 10만원 이상이면 0.2
	// 5만원 이상이면 0.1
	// 5만원보다 적으면 0.05

	static public double disCountRate(int price) {
		
		if(price >= 100000) {
			return RATE_HIGHT;
		}else if(price >= 50000) {
			return RATE_MID;
		}else {
			return RATE_LOW;
		}
	}
	
	// 최종 금액을 계산하는 calculatePrice 메서드 작성
	// 금액별 할인률이 적용된 금액 반환하는 메서드
	// 메서드 내부에서 메서드를 호출할 수 있다.
	public double calculatePrice(int price) {
		double rate = disCountRate(price);
		return price * (1 - rate);
	}
	
	
}
