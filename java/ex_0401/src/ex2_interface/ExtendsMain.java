package ex2_interface;

public class ExtendsMain {
	public static void main(String[] args) {
		
		InterfaceCImpl impl = new InterfaceCImpl();
		
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
