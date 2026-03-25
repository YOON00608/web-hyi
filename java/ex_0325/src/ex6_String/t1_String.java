package ex6_String;

import java.util.Scanner;

public class t1_String {
	
	public static void main(String[] args) {
		// 문자열을 입력받아, 중복된 문자를 제거하고 처음 등장한 순서대로 출력하기
		
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 :");

        String input = sc.nextLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // result에 이미 포함되어 있는지 확인
            
            if (result.indexOf(ch) == -1) {
                result = result + ch; // 문자열 이어붙이기
            }
        }

        System.out.println(result);
	}
	
	
}
