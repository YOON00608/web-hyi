package ex7_Example;

public class Main {
	public static void main(String[] args) {
		
		Calculator plus = new CalPlus();
		Calculator minus = new CalMinus();
		
		System.out.println(plus.getResult(15, 15));
		System.out.println(minus.getResult(30, 15));
	}
}
