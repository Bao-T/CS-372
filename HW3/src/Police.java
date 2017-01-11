/**
 * This class is the child class of Person and has an instance of Employee
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 * @see Person
 * @see Employee
 */
public class Police extends Person implements Employee{
	private policeRoll roll;
	private double wage;
	private double balance = 0;
	/**
	 * Constructor
	 * @param n is the name
	 * @param a is the age
	 * @param p is the phone number
	 * @param r is the Police's roll from an enum
	 * @param w is the Police's wage an hour
	 * @see Person
	 * @see Employee
	 */
	public Police(String n, int a, int p, policeRoll r, double w){
		super(n,a,p);
		roll = r;
		employeeID++;
		wage = w;
		employeeID=currentIDCount;
		currentIDCount++;
	}
	/**
	 * Adds an instance of wage to overall balance
	 */
	public void givePay(){balance += wage;}
	/**
	 * Gets the employeeID
	 * @return employeeID
	 */
	public int getID(){return employeeID;}
	/**
	 * Gets the balance
	 * @return balance
	 */
	public double getBalance(){return balance;}
	/**
	 * Gets the hourly wage
	 * @return wage
	 */
	public double getWage(){return wage;}
	/**
	 * Gets a formatted string of this class' data
	 * @return the string with all the data
	 */
	public String getData(){
		String s = String.format("Name: %s\nAge: %d\nPhone: %d\nPolice Roll: %s\nHourly Wage: $%f\nBalance: $%f\nEmployee ID: %d",name,age,phoneNumber,roll.toString() , (float)wage,(float)balance,employeeID);
		return s;
	}
}
/**
 * enum containing the rolls possible of a Police object
 * @author Bao Tran
 *
 */
enum policeRoll{
	Patrol,Sargent,Captain,Chief
}