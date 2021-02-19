package chp10.ex19;

public class Account {
	private final Long id;
	private double balance;
	private String password;
	
	private static long sid = 10000;
	
	public Account(double balance, String password) {
		this.id = ++sid;
		this.balance = balance;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
