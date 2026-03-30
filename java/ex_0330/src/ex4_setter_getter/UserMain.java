package ex4_setter_getter;

public class UserMain {
	public static void main(String[] args) {
		
	User u = new User();
	
	u.setUsername("자바123");
	u.setPassword("12345678");
	u.setEmail("cakesopdj@naver.com");
	
	System.out.println(u.getUsername());
	System.out.println(u.getPassword());
	System.out.println(u.getEmail());
	
	
	
	
	}	
}
