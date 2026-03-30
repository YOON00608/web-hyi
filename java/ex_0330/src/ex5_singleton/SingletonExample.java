package ex5_singleton;

public class SingletonExample {
	public static void main(String[] args) {
		
	
	// 생성자가 private 로 정의되어 있기 때문에
	// 다른 클래스에서 호출하는게 불가능하다.
	// Singleton obj = new Singleton();
	
		
	// Singleton 클래스에서 만들어둔 객체를 받아온 것.
	// 2개처럼 보이지만, 받아온 것이라 결국 1개임
	Singleton obj1 = Singleton.getInstance();
	Singleton obj2 = Singleton.getInstance();
	
	// obj 와 obj2 같은 객체인지 증명하기
	// 같은 객체면 " 같은 객체입니다. "
	// 아니면 " 같은 객체가 아닙니다. "
	
	if(obj1 == obj2) {
		System.out.println("같은 객체입니다.");
	}else {
		System.out.println("같은 객체가 아닙니다.");
	}
	
	
	
	
	
	}
}
