package ex1_Operator;
import java.util.Scanner;
public class EX3_Example {
	public static void main(String[] args) {
		// 상자 하나에는 농구공이 5개가 들어갈 수 있다.
		// 만일 농구공이 23개라면 몇 개의 상자가 필요한가?
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("공의 개수 : ");
//		int ball = sc.nextInt();
//		
//		int box =  ball % 5 == 0 ? ball / 5 : ball / 5 + 1;
//		System.out.println("필요한 상자 수 : " + box);
//		
//		sc.close();
//		
		// ---------------------------------------
		
		// 사각형의 가로와 세로의 길이를 입력받아
		// 넓이와 둘레 구하기
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("가로 : ");
//		int w = sc.nextInt();
//		
//		System.out.print("세로 : ");
//		int h = sc.nextInt();
//		
//		double a = w * h;
//		double r = 2 * ( w + h );
//		System.out.println("넓이" + a);
//		System.out.println("둘레" + r);
//		
		// 학생은 하루에 일정한 금액의 용돈을 받는다.
		// 하루의 받는 용돈 : money
		// 날짜 수 : day
		// 총 받은 용돈에서 사용한 금액 used를 뺀 남은 돈을
		// 출력하는 코드 작성하기
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("하루 용돈: ");
//		int money = sc.nextInt();
//		
//		System.out.print("날짜 수 : ");
//		int day = sc.nextInt();
//		
//		System.out.println("사용한 돈 : ");
//		int used = sc.nextInt();
//		
//		int r = (money * day) - used;
//		System.out.println("남은 돈 : " + r);
//		
		// 국어, 영어, 수학에 대한 점수를 키보드에서 입력받는다.
		// 1. 세 과목에 대한 합계 출력하기
		// 2. 평균 출력하기 (합계/3.0)
		// 3. 세 과목의 점수가 각각 60점 이상이고, 평균이 60점 이상일 때 합격
		// 아니면 불합격 처리.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수: ");
		int k = sc.nextInt();
		
		System.out.print("영어 점수: ");
		int e = sc.nextInt();
		
		System.out.print("수학 점수: ");
		int m = sc.nextInt();
		
		int sum = k + e + m;
		double a = (sum) / 3;
		
		System.out.println("세 과목 합계 : " + sum);
		System.out.println("평균 : " + a);
		
		boolean t = (k >= 60 && e >= 60 && m >= 60 && a >= 60)
				? true : false;

		System.out.println("결과 : " + t);
	}
}
