package ex5_polymorphism.exam02;

public class Order {
	
	Payment payment;
	
	public void executePay(int amount) {
		payment.pay(amount);
	}
}
