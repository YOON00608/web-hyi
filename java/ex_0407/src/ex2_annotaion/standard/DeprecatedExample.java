package ex2_annotaion.standard;

public class DeprecatedExample {
	
	// 앞으로 사용되지 않을 것을 권장하는 대상에게 붙인다.
	
	@Deprecated
	public static void oldMethod() {
		System.out.println("오래된 메서드");
	}
	
	public static void main(String[] args) {
		oldMethod();
	}
	
}
