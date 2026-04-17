package ex1_stream.exam;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {
	public static void main(String[] args) {
		
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "홍길동", "ACTIVE"));
		members.add(new Member(2, "김철수", "INACTIVE"));
		members.add(new Member(3, "이영희", "ACTIVE"));
		members.add(new Member(4, "박민수", "INACTIVE"));
		members.add(new Member(5, "최지은", "ACTIVE"));
		
		// 상태가 ACTIVE인 회원만 출력하기
		members.stream()
			   .filter(x -> x.getStatus().equals("ACTIVE"))
			   .forEach(System.out::println);
		
	}
}
