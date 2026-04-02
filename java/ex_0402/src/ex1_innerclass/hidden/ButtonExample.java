package ex1_innerclass.hidden;

public class ButtonExample {
	public static void main(String[] args) {
		// 메서드에 매개변수로 전달하는 방식을 이용하여
		// 이벤트 처리하기
		
		Button btnOk = new Button();
		Button btnCancle = new Button();
		
		// setter 호출하기
		btnOk.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("확인버튼을 누른다.");
			}
		});
		btnOk.click();
		
		btnCancle.setClickListener(new Button.ClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("취소버튼을 누른다.");
			}
		});
		btnCancle.click();
	}
}
