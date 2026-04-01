package ex3_interface.exam2;

public class Main {
	public static void main(String[] args) {
		
		Button b = new Button();
		
		b.setListener(new LoginListener());
		b.Click();
		
		b.setListener(new LogoutListener());
		b.Click();
	}
}
