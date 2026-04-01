package ex2_interface;

public class ExtendsMain {
	public static void main(String[] args) {
		
		InterfaceCImpl impl = new InterfaceCImpl();
		
		// 인터페이스의 타입 변환
		// 인터페이스와 구현클래스 사이에서 발생한다.
		
		// 자동 타입변환
		// 구현 객체 EX) InterfaceCImpl impl = new InterfaceCImpl();
		// 를 인터페이스 타입변수에 대입할 때 발생한다.
		
		// 강제 타입변환
		
		InterfaceA ia = impl;
		ia.methodA();
		// B, C는 안 됨.
		System.out.println();
		
		InterfaceB ib = impl;
		ib.methodB();
		// A, C는 안 됨.
		System.out.println();
		
		// 다른 인터페이스를 상속 받았기 때문에 세 개의 메서드 전부 가능하다.
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
	}
}
