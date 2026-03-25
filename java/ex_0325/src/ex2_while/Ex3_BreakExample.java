package ex2_while;

import java.util.Scanner;

public class Ex3_BreakExample {
	public static void main(String[] args) {
		// 1 ~ 45 사이의 난수 뽑기
//		int rand = (int)(Math.random()*45)+1;
//		Scanner sc = new Scanner(System.in);
//		
//		int answer;
//		
//		while(true) {
//			System.out.print("정답 : ");
//			answer = sc.nextInt();
//			
//			// 입력받은 answer랑 난수랑 일치하면
//			// 반복문을 빠져나가게 해줘
//			
//			if(answer == rand) {
//				break;
//			}
//		}
		
		// updown 게임을 for문을 이용해서 만들기
		// 중간에 정답을 맞추면 반복문을 종료하고 "정답입니다!" 출력하기
		// 입력한 값이 정답보다 작으면 "up"
		// 입력한 값이 정답보다 크면 "down"
		// 10번만에 못 맞추면 "정답을 맞추지 못했습니다..." 출력하기
		// "n번만에 정답을 맞췄습니다." 추가
		
//		Scanner sc = new Scanner(System.in);
//		int answer = (int)(Math.random()*50) +1;
//		
//		boolean isMatched = false; // 처음엔 못 맞춘 상태라서 false
//		
//		for(int i = 1; i < 10; i++) {	// 최대 10번 반복 입력 받기 담당
//			System.out.print("찾는 숫자를 입력 >>");
//			int guess = sc.nextInt();
//			
//			if(guess == answer) {
//				System.out.println("정답입니다!");
//				System.out.println(i + "번만에 정답을 맞췄습니다!");
//				isMatched = true; // 여기서 맞추면 break를 걸어서 반복문 종료
//				break;
//			}else if(guess < answer) {
//				System.out.println("up");
//			}else {
//				System.out.println("down");
//			}
//		}
//			if(!isMatched) {
//				System.out.println("정답을 맞추지 못했습니다...");
//				System.out.println("정답은" + answer + "이였습니다.");
//			}
			
			
			System.out.println("---------------------------------------------");
			
			// 라벨
			outer : for(int i = 1; i <= 5; i++) {
				for(int j = 1; j <= 5; j++) {
						System.out.println(i + " " + j);
						if(j == 3) {
							break outer;
					}
				}
			}
		
		
		
		
	}
}
