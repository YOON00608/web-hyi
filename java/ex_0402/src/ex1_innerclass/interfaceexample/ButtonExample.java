package ex1_innerclass.interfaceexample;

public class ButtonExample {
	public static void main(String[] args) {
		
		Button btnOk = new Button(); // 객체 생성
		
		// 내부 인터페이스를 구현하는 클래스
		class OkListener implements Button.ClickListener{
			
			// 추상 메서드 오버라이딩
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 클릭했습니다.");
			}
		}
		//
		
		btnOk.setClickListener(new OkListener());
		
		// ok버튼 클릭하기
		btnOk.click(); // OK 버튼을 클릭했습니다.
		
		// ------------------------------------
		// Cancle 버튼과 기능 만들기
		Button btnNo = new Button();
		
		class Cancle implements Button.ClickListener{

			@Override
			public void onClick() {
				System.out.println("버튼을 취소합니다.");
			}
		}
		
		btnNo.setClickListener(new Cancle());
		btnNo.click(); // 버튼을 취소합니다.
		
	}
}
