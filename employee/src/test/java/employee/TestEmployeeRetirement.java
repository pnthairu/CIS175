package employee;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.EmpBusinessLogic;
import model.Employee;

public class TestEmployeeRetirement {
	
	EmpBusinessLogic empBL =  new EmpBusinessLogic();
	Employee employee = new Employee();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAbove65() {
		employee.setAge(70);
		assertTrue(empBL.isRetirementAge(employee));
		
	}
	
	@Test
	public void testLow65() {
		employee.setAge(25);
		assertTrue(empBL.isRetirementAge(employee));
		
	}

}
