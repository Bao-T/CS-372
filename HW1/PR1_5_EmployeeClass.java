
public class PR1_5_EmployeeClass {

	public static void main(String[] args) {
		Employee e[] = {new Employee("Demi","Lovato",9000),new Employee("Taylor","Swift",12000)};
		for(Employee em:e)
			{System.out.printf("%s %s's yearly salary is $%d.\n",em.getFirstName(),em.getLastName(),(int)em.getMonthlySalary()*12);
			}
		for(Employee em:e)
			{
			em.setMonthlySalary(em.getMonthlySalary()*1.1);
			System.out.printf("After a 10%% rasie %s %s's yearly salary is $%d.\n",em.getFirstName(),em.getLastName(),(int)em.getMonthlySalary()*12);
			}
		
	}
}

class Employee{
	private String firstName,lastName;
	private double monthlySalary;
	public Employee(String first,String last,double Salary)
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
