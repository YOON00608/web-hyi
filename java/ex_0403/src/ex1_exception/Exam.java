package ex1_exception;

import java.util.Scanner;

public class Exam {
	
	public static void main(String[] args) {
		
		// 키보드에서 정수를 입력받고, 정수 이외의 값이 입력되었다면
		// "정수만 입력가능" 메시지 출력하기
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			System.out.println("결과 :  ");
		} catch (Exception e) {
			System.out.println("정수만 입력가능");
		}
	}
}
