package chp6;

class Bank{
	public Account openAccount(long id, String password, int type){
		double balance = 0;
		Account a = null;
		switch(type){
			case 0 : a = new Account();break;
			case 1 : a = new SavingAccount(); break;
			case 2 : a = new CreditAccount();break;
		}
		a.setId(id);
		a.setBalance(balance);
		a.setPassword(password);
		return a;
	}
	
	public double deposit(Account a, double amount){
		double balance = a.getBalance() + amount;
		a.setBalance(balance);
		return balance;
	}
	
	public double withdraw(Account a, double amount){
		double balance = a.getBalance();
		if (balance < amount && !(a instanceof CreditAccount) ){
			System.out.println("余额不足且不能透支");
			return balance;
		}
		balance -= amount;
		a.setBalance(balance);
		return balance;
	}
}


public class TestBank {

	public static void main(String[] args) {

	}

}
