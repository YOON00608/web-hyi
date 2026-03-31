package ex3_protected.package2;
import ex3_protected.package1.A;
public class D extends A {
	
	public D() {
		super();	// A 클래스의 생성자 호출
	}
	
	public void methhod1() {
		// 상속받은 필드나 메서드를 사용할 수 있다.
		this.field = "value";
		this.method();
	}	
	
	public void method2() {
		// 생성자를 직접 호출할 수는 없다.
		// A a = new A(); 
		// a.field = "Value";
		// a.method;
	}
}
