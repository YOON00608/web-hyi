package ex4_innerclass.instanceclass;

public class A {
	
	// 인스턴스(=객체) 멤버 클래스
	// 일반 클래스와 마찬가지로 필드, 생성자, 메서드를 선언할 수 있다.
	// 외부클래스의 멤버를 사용할 목적으로 만든다.
	class B{
		
		int field1 = 1; // 필드
		
		static int field2 = 2; // 정적 필드
		
		B(){
			System.out.println("B-생성자 실행"); // 생성자
		}
		
		void mathod1() {
			System.out.println("B-method 실행"); // 메서드
		}
		
		static void method2() {
			System.out.println("B-method2 실행"); // 정적 메서드
		}
		
	}
	
	B useB() {
		B b = new B(); // 내부클래스의 객체 생성
		return b;
	}
}
