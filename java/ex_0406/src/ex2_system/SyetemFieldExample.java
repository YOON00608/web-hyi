package ex2_system;

import java.util.Scanner;

public class SyetemFieldExample {
	public static void main(String[] args) {
		
		// System.out : 표준 출력 장치
		// 콘솔의 메시지를 출력할 때 사용한다.
		System.out.println(System.out); // java.io(패키지).PrintStream(클래스)@1176dcec(주소)
		
		// System.in : 표준 입력 장치
		// 키보드에서 입력 받을 때 사용한다.
		System.out.println(System.in); // java.io.BufferedInputStream@120d6fe6
		
		// System.err : 표준 에러 출력 장치
		// 오류 메시지를 출력할 때 사용한다.
		System.out.println(System.err); // java.io.PrintStream@4ba2ca36
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 일반 출력은 System.out"); // 출력
		
		System.err.println("2. 에러 출력은 System.err"); // 에러
		
		System.out.print("3. 이름을 입력하세요 : "); // 입력
		String name = sc.next();
		System.out.println("입력한 이름 : " + name);
		
	}
}
