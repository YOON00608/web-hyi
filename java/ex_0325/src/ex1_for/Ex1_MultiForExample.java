package ex1_for;

public class Ex1_MultiForExample {
	public static void main(String[] args) {
		
		for(int i = 1; i <=3; i++) {
			for(int j = 1; j <=3; j++) {
				System.out.println(i + " " + j);
			}
		}
		// 기준이 되는 숫자랑 나머지를 비교할 때 사용
		
		System.out.println("---------------------------------------------");
		
		// 두 개의 주사위를 던졌을 때,
		// 두 눈의 합이 6이 되는 모든 경우의 수 출력하기
		
		for (int d = 1; d <= 6; d++) {
			for(int d2 = 1; d2 <= 6; d2++) {
				if (d + d2 == 6) {
					System.out.println(d + " , " + d2);
				}
			}
		}
		
		System.out.println("---------------------------------------------");
		
		// 1 2 3 4
		// 1 2 3 4
		// 1 2 3 4
		
		for (int i = 1; i <= 3; i++) {	// 행의 개수만큼 반복(가로)
			for(int j = 1; j <=4; j++) { // 열의 개수만큼 반복(세로)
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------------");
	
		// 1 2 3 4
		// 5 6 7 8
		// 9 10 11 12
		int num = 1; // 실제로 출력되는 숫자
		
		for (int i = 1; i <= 3; i++) { // 줄을 몇 번 찍을지 결정
			for(int j = 1; j <= 4; j++) { // 한 줄에 숫자를 몇 개 찍을지 결정
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------------");
		
		// A B C D
		// E F G H
		// I K K L
		
		// 아스키코드 활용하기
		
		char ch = 'A';
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(ch++ + " ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------------");
		
		
	}
}
