package account;
// this class is for testing my java classes that is
// BankAccount class, savingsAccount class and checkingAccount class
public class Main {

	public static void main(String[] args) {
		
		SavingsAccount savings = new SavingsAccount(0.5);
		savings.setAccountName("Peter Smith");
		savings.setAccountNo(101010);
		savings.setBalance(1000);
		savings.addInterest();
		savings.deposit(100);
		savings.withdraw(5);
		System.out.println(savings.toString());
		
		CheckingAccount checking = new CheckingAccount(500);
		checking.setAccountName("Julie Joe");
		checking.setAccountNo(111111);
		checking.setBalance(1000);
		checking.deposit(100);
		checking.withdraw(50);
		System.out.println(checking.toString());
		
		

	}

}
