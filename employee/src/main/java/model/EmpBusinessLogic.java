package model;

public class EmpBusinessLogic {
	
	public double calculateYearlySalary(Employee employee) {
		double yearlySalary = 0;
		yearlySalary = employee.getMonthlySalary() * 12;
		return yearlySalary;
	}
	
	public double calculateAppraisal(Employee employee) {
		double appraisal = 0;
		if (employee.getMonthlySalary() < 10000) {
			appraisal = 500;			
		}
		else {
			appraisal = 1000;
		}
		return appraisal;
	}
	
	public Boolean isRetirementAge(Employee employee) {
		boolean retirementAge = true;
		
		if (employee.getAge() > 65) {
			System.out.println("Is the employe aged "+"70"+" due for retirement: " + retirementAge);			
		}
		else {
		System.out.println("Is the employe aged "+"25"+" due for retirement: " + false);
		}
		
		return retirementAge;
		
	}

}
