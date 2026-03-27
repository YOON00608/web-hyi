package ex3_overloding;

public class CalcMain {
	public static void main(String[] args) {
		Calc c = new Calc();
		c.area(4, 3);
		c.area(4.2, 3.5);
		
		///////
		System.out.println();
		
		System.out.println(c.area(6));
	}
}
