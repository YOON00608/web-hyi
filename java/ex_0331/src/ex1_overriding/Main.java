package ex1_overriding;

public class Main {
	public static void main(String[] args) {
		double r = 5.0;
		
		// Calculator 객체 만들고 메서드 호출하기
		Calculator calculator = new Calculator();
		System.out.println();
		System.out.println("원 면적 : " + calculator.areaCirclr(r)); // 원 면적 : 78.5
		
		// 컴퓨터 객체 만들어서 오버라이딩된 메서드 호출해보기
		
		Computer computer = new Computer();
		System.out.println("원 면적 :" + computer.areaCirclr(r)); // 원 면적 :78.53981633974483
		
		// 오버라이딩의 경우 상속관계에서만 사용할 수 있다.	
	}
}
