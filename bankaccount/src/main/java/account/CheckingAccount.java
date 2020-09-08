package account;
//Setting up checking account which inherits details from BankAccount class
public class CheckingAccount extends BankAccount{
	// creating checking account variable in addition to BankAccount variables
	private double balance;
	

	// constructor with one argument
	public CheckingAccount(double bal) {
		this.balance = bal;
	}
	
	// Method to print checking account balance
	public double printCheckingAccBal() {
		System.out.print(this.getAccountName() + " Checking Account balance is: ");
		return this.getBalance();
	}
	
}
