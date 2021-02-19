package chp7;

class Account{
	private final long id;
	private double balance;
	private String password;
	private static long sid = 100000;
	
	public Account(){
		sid++;
		id = sid;
	}
	
	public long getId() {
		return id;
	}
	/*注意：要去掉setId方法
	public void setId(long id) {
		this.id = id;
	}*/
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return null;
	}
	public void setPassword(String password) {
		if (password.length() != 6) return;
		this.password = password;
	}
}


public class TestAccount{
	public static void main(String args[]){
		Account a1 = new Account();
		Account a2 = new Account();
		System.out.println(a1.getId());
		System.out.println(a2.getId());
	}
}