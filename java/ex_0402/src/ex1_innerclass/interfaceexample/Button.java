package ex1_innerclass.interfaceexample;

public class Button {
	
	// static 붙이지 않아도 자동으로 처리가 된다.
	// 중첩 interface는 무조건 static 이다. (암묵적 static)
	public interface ClickListener{ // static 들어가 있음.
		void onClick(); // 추상 메서드
	}
	
	// 필드랑 setter 
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	// 버튼이 클릭 되었을 때 실행할 메서드로 click() 메서드 추가하기
	// 실행 내용은 ClickListener 인터페이스 필드를 이용해서 onClick() 추상메서드 호출하기
	
	public void click() {
		clickListener.onClick();
	}
}
