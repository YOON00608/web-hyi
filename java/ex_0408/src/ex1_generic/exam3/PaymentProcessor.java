package ex1_generic.exam3;

public class PaymentProcessor<T extends Payment> {
	private T payment;
	
	public PaymentProcessor(T payment) {
		this.payment = payment;
	}
	
	public void process() {
		payment.Pay();
	}
	
}
