package resource;

public class MyResource implements AutoCloseable {

	private String name;
	
	// 생성자를 통해서 name 필드를 초기화
	// 리소스를 열었다고 가정
	public MyResource(String name) {
		this.name = name;
		System.out.println("[MyResource("+name+")열기]");
	}
	
	
	// 리소스를 읽는다고 가정하는 메서드
	public String read1() {
		System.out.println("[MyResource("+name+")열기]");
		return "100";
	}
	
	public String read2() {
		System.out.println("[MyResource("+name+")열기]");
		return "abc";
	}
	
	// 리소스를 닫음
	@Override
	public void close() throws Exception {
		System.out.println("[MyResource("+name+")닫기]");
		
	}
	
	
	
	
}
