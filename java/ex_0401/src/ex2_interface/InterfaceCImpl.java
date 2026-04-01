package ex2_interface;

public class InterfaceCImpl implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("구현제 methodA 실행");
	}

	@Override
	public void methodB() {
		System.out.println("구현제 methodB 실행");
	}

	@Override
	public void methodC() {
		System.out.println("구현제 methodC 실행");
	}
	
}
