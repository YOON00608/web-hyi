package ex4_setter_getter;

public class Car {
	
	// private 으로 선언된 필드는 외부에서 접근이 안 된다.
	private int speed;
	private boolean stop;
	
	// setter & getter
	// private 으로 선언된 필드에 접근할 수 있도록 해주는 메서드
	
	// speed 의 값을 세팅해주는 setSpeed 메서드 만들기
	// 속도값은 호출할 때 받아온다.
	// 속도가 0보다 작은 경우 0으로 만든다.
	// 0보다 크면 필드에 세팅한다.
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return; // 없어도 오류가 나는 건 아니지만, break 효과를 준다.
		}else {
			this.speed = speed;
		}
	}
	
	///////////
	
	// speed 의 값을 반환하는 getSpeed 메서드 만들기
	
	public int getSpeed() {
		return speed;
		
	}
	
	//////////// 
	public void setStop(boolean stop) {
		this.stop = stop;
		if(stop == true) {
			this.speed = 0;
		}
	}
	
	public boolean isStop() {
		return this.stop;
	}
	
	
	
	
	
}
