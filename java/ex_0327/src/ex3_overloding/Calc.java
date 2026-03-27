package ex3_overloding;

public class Calc {
	// 직사각형의 넓이를 구하는 area 메서드를 작성하세요
	// 넓이는 메서드 내에서 출력하고 종료
	// 가로와 세로 길이는 매개변수를 통해 받는다.
	
	public void area(int x, int y) {
		int a = x * y;
		System.out.println(a);
	}
	
	public void area(double x, double y) {
		double a = x * y;
		System.out.printf("%.1f",a);
	}
	
	// 오버로딩 해서 정사각형의 넓이를 구하는 매서드 만들기
	// 길이는 매개변수로 받는다.
	
	public int area(int z) {
		int sq = z * z;
		return sq;
		
	}
}
