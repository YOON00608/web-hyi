package ex1_exception.customExecption;

public class AccountMain {
	public static void main(String[] args) {
		
		Account a = new Account();
		
		a.deposit(100000);
		System.out.println("예금액 : " + a.getBalance());
		
		try {
			a.withdraw(30000);
			System.out.println("예금액 : " + a.getBalance());
		} catch (InsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		
		}
		
		
		
	}
}
