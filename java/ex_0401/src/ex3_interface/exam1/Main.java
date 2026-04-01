package ex3_interface.exam1;

public class Main {
	public static void main(String[] args) {
		
		Notification[] n = {new SmsNotification(),new EmailNotification()};
		
		for(Notification notification : n) {
			notification.send("1234");
		}
	}
}
