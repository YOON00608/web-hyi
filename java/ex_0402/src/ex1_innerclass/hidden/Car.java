package ex1_innerclass.hidden;

public class Car {
	
	private Tire tire1 = new Tire();
	private Tire tire2 = new Tire() {
		
		// 익명클래스 영역 (클래스의 이름이 없는데 오버라이딩이 된다.)
		@Override
		public void roll() {
			System.out.println("오버라딩 타이어가 굴러갑니다.");
		}
	};
	
	// 1. 필드 이용
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	// 2. 지역변수 이용
	public void run2() {
		Tire tire = new Tire() {
			public void roll() {
				System.out.println("지역변수 타이어가 굴러갑니다.");
			}
		};
		tire.roll();
	}
	
	// 3. 매개변수 이용
	public void run3(Tire tire) {
		tire.roll();
	}
	
	
	
}
