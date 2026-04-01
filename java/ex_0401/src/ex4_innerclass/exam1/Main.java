package ex4_innerclass.exam1;

public class Main {
	public static void main(String[] args) {
		
		Order o = new Order(2026003);
	
		Order.Item item = o.new Item("키보드", 50000, 2);
		
		o.printOrderInfo(item);
	}
}
