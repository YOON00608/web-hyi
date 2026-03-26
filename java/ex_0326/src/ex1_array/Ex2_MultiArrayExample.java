package ex1_array;

import java.util.Scanner;

public class Ex2_MultiArrayExample {
	public static void main(String[] args) {
		// 2차원 배열 : 1차원 배열을 요소로 갖는 배열
		
		// 2차원 배열의 초기화
		int [][] arr = {{1,2,3},{4,5,6},{7,8,9}}; // -> 2차원 배열의 요소는 3개
		
		// 2차원 배열의 선언과 생성
		// 1차원 배열과 마찬가지로 길이를 지정해줘야 한다.
		int [][] ar = new int[2][3]; // -> {0,0,0}, {0,0,0} 
		
		// 배열의 각 공간에 접근하는 방법
		// -> 배열명[요소의 index][1차원 배열의 index];
//		System.out.println(arr[0][0]); // 1
//		System.out.println(arr[0][1]); // 2
//		System.out.println(arr[0][2]); // 3
//		System.out.println(arr[1][0]); // 4
//		System.out.println(arr[1][1]); // 5
//		System.out.println(arr[1][2]); // 6
		
		// -> 이렇게 하지 말고
		
		// arr.length : 2차원 배열의 길이
		// arr[i].length : 해당 1차원 배열의 길이
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
		System.out.println("-----------");
		
		// 각 1차원 배열에 들어가는 데이터의 개수가 다른 경우
		
		// 2차원 배열에 들어가는 요소의 개수만 일단 지정한다.
		int[][] iAr = new int[3][]; // 1차원 배열은 일단 상자만 만들어둠
		
		// 각 1차원 배열의 들어가는 데이터의 개수를 따로 지정할 수 있다.
		iAr[0] = new int[1];
		iAr[1] = new int[2];
		iAr[2] = new int[3];
		
		// -> {0} {0,0} {0,0,0}
		
		iAr[0][0] = 100; // {100}
		iAr[1][0] = 200; // {100}, {200,}
		iAr[1][1] = 300; // {100}, {200,300}
		iAr[2][0] = 400; // {100}, {200,300}, {400, ,}
		iAr[2][1] = 500; // {100}, {200,300}, {400,500,}
		iAr[2][2] = 600; // {100}, {200,300}, {400,500,600}
		
		// 다음 2차원 배열의 모든 요소의 총 합을 구하세요.
		
		System.out.println("-----------");
		
		int[][] num = {{1},{2,3},{4,5,6},{7,8,9,10}};
		// 2차 배열은 4
		// 1차 배열은 0 / 0,1 / 0,1,2 / 0,1,2,3
		
		int sum = 0;
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				sum += num[i][j];
			}
		}
		System.out.println(sum);
		
		System.out.println("-----------");
		
		// 학생들의 수학과 영어성적을 등록하는 프로그램이 있다.
		// 프로그램을 실행하면 몇 명의 정보를 저장할 것인지를 입력한 후,
		// 입력받은 수 만큼 학생들의 이름과 수학,영어 성적을 입력받는
		// 프로그램 작성하기
		
		// 예시
		// 등록할 인원 수 : 2
		// 이름 : 홍길동
		// 수학 : 90
		// 영어 : 87
		// --------------------------
		// 이름 : 독고길동
		// 수학 : 70
		// 영어 : 100
		// -------------------------
		// 2명 등록 완료
		// 홍길동 90 87
		// 독고길동 70 100
		
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 인원 수 : ");
		int people = sc.nextInt();
		
		String[][] score = new String[people][3];
		
			for(int i = 0; i < score.length; i++){
				System.out.print("이름: ");
				score[i][0] = sc.next();
				System.out.print("수학: ");
				score[i][1] = sc.next();
				System.out.print("영어: ");
				score[i][2] = sc.next();
			}
			System.out.println(score.length + "명 등록완료!");
			for(int i = 0; i < score.length; i++) {
				for(int j = 0; j < score[i].length; j++) {
					System.out.print(score[i][j] + " ");
				}
				System.out.println();
			}
			
			
			
			
			
			
	}
}
