package account;

// Setting up savings account which inherits details from BankAccount class
public class SavingsAccount extends BankAccount{
	// creating savings account variable in addition to BankAccount variables
	private double interestRate;
	
	// constructor with one argument
	public SavingsAccount (double intRate) {
		this.interestRate = intRate;				
	}
	
	// method to calculate the interest rate
	public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

	// Method to print saving account balance
	public double printSavingsAccBal() {
		System.out.print(this.getAccountName() + " Savings Account balance is: ");
		return this.getBalance();
	}
}
