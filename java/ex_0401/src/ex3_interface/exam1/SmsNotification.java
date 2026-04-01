package ex3_interface.exam1;

public class SmsNotification implements Notification {

	@Override
	public void send(String message) {
		System.out.println("[SMS]" + message + "를 전송합니다.");
	}
}
