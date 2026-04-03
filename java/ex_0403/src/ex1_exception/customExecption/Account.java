package ex1_exception.customExecption;

public class Account {
	
	private long balance;
	
	public Account() {};
	
	// 잔액을 반환하는 getter
	
	public long getBalance() {
		return balance;
	}
	
	// 돈을 전달받아서 입금을 하는 메서드 deposit()

	public void deposit(long money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException {
		if(balance < money) {
			throw new InsufficientException("잔고 부족 : " + (money-balance) + "원 모자람");
		}
		balance -= money;
	}
	
}
