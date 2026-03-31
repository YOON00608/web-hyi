package ex5_polymorphism.exam02;

public class Main {
	public static void main(String[] args) {
		
		Order o = new Order();
		
		// 카드
		o.payment = new CardPayment();
		o.executePay(50000);
		
		// 카카오페이
		o.payment = new KakaoPayment();
		o.executePay(30000);
	}
}
