package ex5_polymorphism.exam02;

public class KakaoPayment extends Payment {

	@Override
	public void pay(int amount) {
		System.out.println("카카오페이로 " + amount + "원을 결제합니다.");
	}
}
