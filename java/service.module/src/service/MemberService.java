package service;
import member.Member;
public class MemberService {
	
	public void register(Member member) {
		System.out.println("회원 등록을 시작합니다.");
		System.out.println("회원 이름 : " + member.getName());
		System.out.println("회원 나이 : " + member.getAge());
		System.out.println("회원 등록이 완료되었습니다.");
	}
	
	// 성인인지 판단하는 CheckAdult() 메서드 만들기
	// 20세 이상이면 "성인 회원입니다."
	// 아니며 "미성년회원입니다."
	
	public void CheckAdult(Member member) {
		
		if(member.getAge() >= 20) {
			System.out.println("성인 회원입니다.");
		}else {
			System.out.println("미성년 회원입니다.");
		}
		
	}
	
}
