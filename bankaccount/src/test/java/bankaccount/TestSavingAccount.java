package bankaccount;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import account.SavingsAccount;

public class TestSavingAccount {
	//Creating savings object from savings account class
	SavingsAccount savings =  new SavingsAccount(0.5);
	
	@Before
	public void setUp() throws Exception {
	}

	// NOT THE UNIT TEST IS FOR ACCOUNT BALANCE, ACCOUNT NAME AND WITHDRAW
	@Test
	public void testSavingsAccountBalance() {		
		savings.setAccountName("Peter Smith");					// setting the account holder name
		savings.setAccountNo(101010);							// setting the account number
		savings.setBalance(1000);								// setting the account balance
		savings.addInterest();									// depositing money from the account
		savings.deposit(100);
		// NOTE IF YOU WITHDRAW MORE THAN THE BALANCE THE TEST WILL FAIL
		savings.withdraw(5);									// withdrawing money in the account			
		
		System.out.println(savings.toString());					// printing account details
		System.out.println(savings.printSavingsAccBal());		// Printing the account balance to see if the same as unit test
		
		/** THREE UNIT TESTING **/
		// Testing if the balance is as expected.
		assertTrue(savings.getBalance() == 1100.0);	
		// testing if the name is the same as setup name
		assertTrue(savings.getAccountName() == "Peter Smith");
		// testing if the account number is the same as setup account number
		assertTrue(savings.getAccountNo() == 101010);
		System.out.println("------------------------------------------------");
	}

}
