package ex1_List.ArrayList.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<UserInfo> list = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			
			UserInfo user = new UserInfo();
			
			System.out.print("아이디 입력 : ");
			user.setId(sc.next());
			
			// 아이디 입력받고 list에 겹치는게 있는지 확인
			outer : for(int j = 0; j < i; j++) {
				if(user.getId().equals(list.get(j).getId())) {
					System.out.println("아이디가 중복됩니다.");
					i--;
					continue outer;
				}
			}
			
			System.out.print("비밀번호 입력 : ");
			user.setPw(sc.nextInt());
			
			list.add(user);
			
			for(UserInfo u : list) {
				System.out.println(u.getId());
				System.out.println(u.getPw());
				System.out.println("-----------");
			}
		}
	}
}
