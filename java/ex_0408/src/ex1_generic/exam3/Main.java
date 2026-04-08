package ex1_generic.exam3;

public class Main {
	public static void main(String[] args) {
		
		PaymentProcessor<CardPayment> card = 
				new PaymentProcessor<>(new CardPayment());
		PaymentProcessor<KakaoPay> kakao = 
				new PaymentProcessor<>(new KakaoPay());
		
		card.process();
		kakao.process();
		
	}
}
