

public class PR1_5_EmployeeClass{
	private String firstName,lastName;
	private double monthlySalary;
	public PR1_5_EmployeeClass(String first,String last,double Salary)
	{
		firstName = first;
		lastName = last;
		monthlySalary = Salary;
	}
	
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public double getMonthlySalary(){return monthlySalary;}
	
	public void setFirstName(String x){firstName = x;}
	public void setLastName(String x){lastName = x;}
	public void setMonthlySalary(double x){
		if(x>0)
			monthlySalary = x;
		}
}
