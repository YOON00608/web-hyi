package ex1_lambda.exam;

import java.util.List;

public class UserService {
	
	// 조건에 따른 람다식 반환
	public UserFilter getFiter(String type) {
		if(type.equals("adult")) {
			return user -> user.getAge() >= 20;
		}else if(type.equals("seoul")) {
			return user -> user.getCity().equals("서울");
		}else if(type.equals("kim")) {
			return user -> user.getName().startsWith("김");
		}else {
			return null;
		}
	}
	
	public void filterUsers(List<User> list, UserFilter filter) {
		for(User user : list) {
			if(filter.test(user)) {
				System.out.println(user);
			}
		}
	}
}
