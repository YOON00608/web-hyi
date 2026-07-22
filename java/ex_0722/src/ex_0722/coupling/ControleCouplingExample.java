package ex_0722.coupling;

public class ControleCouplingExample {
	// 1. isVip라는 boolean 클래스 값에 따라 내부 로직이 달라진다.
	// 2. 호출하는 쪽에서 OrderService 내부가 isVIP를 어떻게 처리하는 지 알고 있어야 한다.
	// 3. 새로운 등급이 생길 때마다 메서드 내부의 if-else 문을 계속 수정해야 한다.
	// 4. 하나의 메서드가 VIP 가격 계산과 일반 가격 계산이라는 두 가지 책임을 동시에 가진다.
	static class OrderService{
		public double calculatePrice(double price, boolean isVIP) {
			if(isVIP) {
				return price * 0.8;
			}else {
				return price;
			}
		}
	}
}
