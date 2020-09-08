package account;

public class BankAccount {
	
	//declaring variables
	private String accountName;
	private int accountNo;
	private double balance = 0;
	
	//default constuctor with no ars
	public BankAccount() {
		
	}
	
	//Constructor 
	public BankAccount(String name, int accNo, double balance) {
		this.accountName = name;
		this.accountNo = accNo;
		this.balance = balance;
	}

	// getter method for account name
	public String getAccountName() {
		return accountName;
	}

	// setter method for account name
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	// getter method for  account number
	public int getAccountNo() {
		return accountNo;
	}

	// setter method for account number
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	// getter method for account balance
	public double getBalance() {
		return balance;
	}

	// setter method for account balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// method to deposit money in the account and updating account balance
	public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Your account balance is below 0");
        }
        balance = balance + amount;
    }
	
	// method to withdraw amount and update account balance
	 public void withdraw(double amount) {
	        if ((balance - amount < 0) || (amount < 0)) {
	           System.out.println("Insufficient fund in your account to withdral. Sorry!! ");
	        }
	        balance = balance - amount;
	 }

	 // Method to print account details
	@Override
	public String toString() {
		return "BankAccount Summary\nAccount Name: " + accountName + " \nAccount No: " + accountNo;
	}	 
	
	 
}
