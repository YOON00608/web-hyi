package ex2_function.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MemberMain {
	public static void main(String[] args) {
		
		List<Member> members = new ArrayList<>();
		members.add(new Member("김철수",25));
		members.add(new Member("용철수",19));
		members.add(new Member("나철수",20));
		
		// 20세  이상인지 검증하는 람다식
		Predicate<Member> adult = m ->m.getAge() >= 20;
		for(Member m : members) {
			if(adult.test(m)) {
				System.out.println(m.getName() + " / " + m.getAge());
			}
		}
		
	}
}
