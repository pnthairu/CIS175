package bankaccount;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import account.CheckingAccount;
import account.SavingsAccount;
public class TestCheckingAccount {
	
	//creating checking object from checking account class
	CheckingAccount checking = new CheckingAccount(100);

	@Before
	public void setUp() throws Exception {
	}

	// NOT THE UNIT TEST IS FOR ACCOUNT BALANCE ONLY
	@Test
	public void testCheckingAccountBalance() {	
		
		checking.setAccountName("Joyce Ramsey");  			// setting the account holder name
		checking.setAccountNo(121212);			  			// setting the account number
		checking.setBalance(800);				  			// setting the account balance
		checking.deposit(150);					  			// depositing money from the account
		
		// NOTE IF YOU WITHDRAW MORE THAN THE BALANCE THE TEST WILL FAIL
		checking.withdraw(500);					  			// withdrawing money in the account
		
		System.out.println(checking.toString());  			// printing account details
		System.out.println(checking.printCheckingAccBal()); // Printing the account balance to see if the same as unit test
		
		/** THREE UNIT TESTING **/
		// Testing if the balance is as expected.
		assertTrue(checking.getBalance() == 450.0);	// IF YOU CHANGE THE AMOUNT THE TEST WILL FAIL
		// testing if the name is the same as setup name
		assertTrue(checking.getAccountName() == "Joyce Ramsey");
		// testing if the account number is the same as setup account number
		assertTrue(checking.getAccountNo() == 121212);
		System.out.println("------------------------------------------------");
	}

}
