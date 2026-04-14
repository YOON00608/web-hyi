package ex1_lambda.exam;

import java.util.ArrayList;
import java.util.List;

public class UserMain {
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		users.add(new User("김철수",25,"서울"));
		users.add(new User("이영희",18,"인천"));
		users.add(new User("김민수",30,"부산"));
		users.add(new User("박지은",22,"서울"));
								
		UserService service = new UserService();
		
		// 다른 메서드가 람다식을 받아서 실행
		System.out.println("=== 성인 회원 ===");
		service.filterUsers(users, service.getFiter("adult"));
		
		System.out.println("=== 서울 거주 회원 ===");
		service.filterUsers(users, service.getFiter("seoul"));
		
		System.out.println("=== 김씨 회원 ===");
		service.filterUsers(users, service.getFiter("kim"));
		
	}
}
