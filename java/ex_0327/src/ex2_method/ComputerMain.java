package ex2_method;

public class ComputerMain {
	public static void main(String[] args) {
		Compter c = new Compter();
		
		// 1,2,3,4,5
		int sum = c.sum(1,2,3,4,5);
		System.out.println("총 합: " + sum); // 15
		
		sum = c.sum(1,2,3);
		System.out.println("총 합: " + sum); // 6
	
	}
}
