package ex1_List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample2 {
	public static void main(String[] args) {
		
		//List<String> names = new ArrayList<>();
		//List<Integer> ages = new ArrayList<>();
		//names.add("홍길동");
		//ages.add(30);
		
		List<Member> members = new ArrayList<Member>();
		
		Member m1 = new Member();
		m1.setName("홍길동"); 
		m1.setAge(30); 
		
		members.add(m1);
		
		System.out.println(members.get(0).getName());
		System.out.println(members.get(0).getAge());
		
		///
		
		members.add(new Member()); // "박민수", 40
		members.get(1).setName("박민수");
		members.get(1).setAge(40);
		
		System.out.println(members.get(1).getName());
		System.out.println(members.get(1).getAge());
		
		members.add(new Member()); // "김철수", 25
		members.get(2).setName("김철수");
		members.get(2).setAge(25);
		
		System.out.println(members.get(2).getName());
		System.out.println(members.get(2).getAge());
		
//		Member m2 = new Member();
//		m2.setName("김철수");
//		m2.setAge(25);
//		
//		members.add(m2);
//		
//		System.out.println(members.get(2).getName());
//		System.out.println(members.get(2).getAge());
		
	}
}
