package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example2 {
	public static void main(String[] args) {
		//학생 이름을 입력 받아 List 에 저장한다.
		//이미 존재하는 이름이면 추가하지 않고, “이미 존재하는 이름입니다.” 메시지를 출력한다.
		Scanner sc = new Scanner(System.in);
		List <String> list = new ArrayList<>();
		
		System.out.println("이름을 입력하세요. (종료 : exit)");
		
		while(true) {
			System.out.print("입력 : ");
			String input = sc.nextLine();
			
			// exit 입력하면 빠져나오기
			if(input.equalsIgnoreCase("exit")) {
                break;
			}
			
			// 이미 존재하는 이름이면 추가하지 않고, “이미 존재하는 이름입니다.” 메시지를 출력
			if(list.contains(input)) { 
				System.out.println("이미 존재하는 이름입니다.");
			}else { // 아니면 추가
				list.add(input);
			}
		}
		
		System.out.println("최종 학생 목록 " + list);
		
	}
}
