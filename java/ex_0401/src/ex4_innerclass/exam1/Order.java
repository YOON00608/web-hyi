package ex4_innerclass.exam1;

public class Order {
	
	int orderNumber;
	
	public Order(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void printOrderInfo(Item item) {
		System.out.println("주문번호 : " + orderNumber);
		item.printInfo();
	}

	/////
	
	class Item{
		
		String name;
		int price;
		int count;
		
		public Item(String name, int price, int count) {
			this.count = count;
			this.name = name;
			this.price = price;
		}
		
		public void printInfo() {
			System.out.println("상품명 : " + name + ", 가격 : " + price + ", 수량 : " + count);

		}
	}
}
