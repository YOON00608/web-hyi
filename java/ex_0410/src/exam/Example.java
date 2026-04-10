package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		// 사용자로부터 여러 개의 문자열을 입력받아 List 에 저장한다.
		// 이후 중복을 제거하고 정렬하여 출력하는 프로그램 작성하기
		// 입력은 exit 입력 시 종료된다.
		
		Scanner sc = new Scanner(System.in);
		List <String> list = new ArrayList<>();
		
		System.out.println("문자열을 입력하세요.(종료 : exit)");
		
		while(true) {
			System.out.print("입력 : ");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("exit")) {
				break;
			}
			list.add(input);
		}
		
		HashSet<String> set = new HashSet<>(list);
		
		List<String> distinctList = new ArrayList<>(set);
		Collections.sort(distinctList);
		
		System.out.println("--- 중복 제거 및 정렬 결과 ---");
		System.out.println(distinctList);
		
		
	}
}
