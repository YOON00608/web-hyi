package ex2_object;

public class ProductMain {
	public static void main(String[] args) {
		
		Product p1 = new Product("키보드", 500, 10);
		Product p2 = new Product("마우스", 15000, 20);
		Product p3 = new Product("모니터", 105000, 100);
		Product[] product = {p1,p2,p3};
		
		
		for(Product p : product) {
			System.out.println(p);
		}
	}
}
