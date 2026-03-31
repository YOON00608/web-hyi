package ex3_protected.package1;
public class B {
	
	// 메서드 선언
	public void method() { 
		// B 클래스는 A 클래스와 동일한 패키지에 있기 때문에
		// protected 로 선언된 필드, 생성자, 메서드에 접근이 가능하다.
		A a = new A();		// O
		a.field = "value";  // O
		a.method();			// O
	}
}
