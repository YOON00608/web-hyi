package ex4_innerclass.instanceclass;

public class AMain {
	public static void main(String[] args) {
		
		A a = new A(); // 외부 클래스의 객체
		
		A.B b = a.new B(); // 인스턴스 내부 클래스의 객체 만들기
		
		A.B b2 = a.useB(); // A 클래스에 미리 생성해서 가져오기
	}
}
