package ex4_class_cating;

class Parent{
	
	public void method1() {
		System.out.println("부모 메서드1");
	}
	
	public void method2() {
		System.out.println("부모 메서드2");
	}
}

class Child extends Parent{
	
	int x;
	
	@Override
	public void method2() {
		System.out.println("자식 메서드2");
	}
	
	public void method3() {
		System.out.println("자식 메서드3");
	}	// 자식에게만 있는 메서드
	
}

public class UpCatingExample {

	public static void main(String[] args) {
		
	Child child = new Child();
	
	// 부모타입으로 변환
	Parent parent = child;
	
	parent.method1(); // 부모 메서드1
	parent.method2(); // 자식 메서드2
	// 부모타입으로 변환해도 오버라이딩된 메서드가 호출 된다. 
	
	// parent.method3(); -> 자식 클래스에 선언된 메서드를 호출하는 것은 불가능하다.
	// parent.x; -> x
	
	// 자식 객체를 부모타입으로 변환하면
	// 자식 클래스에 정의한 멤버(필드,메서드)를 사용할 수 없다.
	
	((Child)parent).method3(); // parent 를 임시로 자식타입으로 변환
	
	Child c2 = (Child)parent;
	c2.x = 100;
	
	}
}
