package ex1_lombok;

public class Main {
	public static void main(String[] args) {
		
		//Member m = new Member();
		//m.setId("2026001");
		//m.setName("홍길동");
		//m.setAge(30);
		
		Member m2 = new Member("2026001","홍길동",40);
		System.out.println(m2); // @ToString 덕분에 이렇게 나옴
		
		// Member(id=2026001, name=홍길동, age=40)
	}
}
