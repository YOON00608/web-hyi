package ex_0722.coupling;

public class EmailService {
	// 오직 email 하나만 필요한데 User 객체 전체를 전달 받는다. 
	// User 클래스의 내부구조가 변경되면, 이메일 발송 기능에도 영향을 미친다.
	// 필요하지 않은 사용자 정보까지 이 메서드에 노출되어 캡슐화/정보은닉 원칙이 악화된다.
	public void sendEmail(User user) {
		System.out.println(user.email+"로 이메일을 발송합니다.");
	}
}
