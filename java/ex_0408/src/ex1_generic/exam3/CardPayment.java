package ex1_generic.exam3;

public class CardPayment implements Payment {

	@Override
	public void Pay() {
		System.out.println("카드로 결제합니다.");
	}
}
