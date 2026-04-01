package ex1_abstract.Example;

public class Main {
	public static void main(String[] args) {
		
		Delivery[] d = {new RoketDelivery(), new StorePickup()};
		
		for(Delivery delivery : d) {
			delivery.printInvoice();	// 송장을 출력합니다.
			delivery.ship();			// 매장에서 직접 수령합니다.
			delivery.clomplete();		// 배송 처리가 완료되었습니다.
			System.out.println("-------------");
		}
	}
}
