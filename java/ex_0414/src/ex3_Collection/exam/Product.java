package ex3_Collection.exam;

public class Product {
	
	private String code; // 제품코드
	private String name; // 제품명
	private int price; // 가격
	private int stock; // 재고
	
	public Product(String code,String name,int price,int stock) {
		this.code = code; 
		this.name = name; 
		this.price = price; 
		this.stock = stock; 
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}
	
	@Override
	public String toString() {
		return String.format("Product{code= %s, name= %s, price= %d, stock= %d}", code,name,price,stock);
		
	}
}
