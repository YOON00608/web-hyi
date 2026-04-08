package ex1_generic.exam2;

public class Main {
	public static void main(String[] args) {
		
		MemberResponse<Member> mr = new MemberResponse<Member>
		(true,"회원 조회 성공",new Member("홍길동",30));
		
		System.out.println("성공 여부 : " + mr.isSuccess());
		System.out.println("메시지 : " + mr.getMessage());
		System.out.println("이름 : " + mr.getData().getName());
		System.out.println("나이 : " + mr.getData().getAge());
		
	}
}
