package prob05;

public class Account {
	
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		accountNo = accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public int getBalance() {
		return this.balance;
	}

	public void save(int i) {
	}

	public void deposit(int i) {
	}
}
