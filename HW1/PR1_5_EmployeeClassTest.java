
public class PR1_5_EmployeeClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PR1_5_EmployeeClass e[] = {new PR1_5_EmployeeClass("Demi","Lovato",9000),new PR1_5_EmployeeClass("Taylor","Swift",12000)};
		for(PR1_5_EmployeeClass em:e)
			{System.out.printf("%s %s's yearly salary is $%d.\n",em.getFirstName(),em.getLastName(),(int)em.getMonthlySalary()*12);
			}
		for(PR1_5_EmployeeClass em:e)
			{
			em.setMonthlySalary(em.getMonthlySalary()*1.1);
			System.out.printf("After a 10%% rasie %s %s's yearly salary is $%d.\n",em.getFirstName(),em.getLastName(),(int)em.getMonthlySalary()*12);
			}
	}

}
