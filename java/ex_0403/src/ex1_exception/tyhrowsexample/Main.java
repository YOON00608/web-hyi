package ex1_exception.tyhrowsexample;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Converter c = new Converter();
		
		try {
			System.out.print("문자열 입력 : ");
			String input = sc.next();
			int num = c.toInt(input);
			System.out.println("변환 결과 : " + num);
		} catch (Exception e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		}
	}

}
