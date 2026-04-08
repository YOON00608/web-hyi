package ex1_generic.exam3;

public class KakaoPay implements Payment {

	@Override
	public void Pay() {
		System.out.println("카카오페이로 결제합니다.");
	}
}
