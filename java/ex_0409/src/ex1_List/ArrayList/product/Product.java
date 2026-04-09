package ex1_List.ArrayList.product;

public class Product {
	private String name;
	private int price;
	private int quantity;
	
	public Product(String name,int price,int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getTotalPrice() {
		return price * quantity; 
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity; // 개수를 바꾸기 위한 quantity의 setter
	}
	
	@Override
	public String toString() {
		return name + "(" + price + "원" + ")" + "x" + quantity + "개";
	}
	
}
