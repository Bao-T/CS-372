/**
 * This class is a child class of Person and has an instance of Employee
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 * @see Person
 * @see Employee
 *
 */
public class Teacher extends Person implements Employee{
	private boolean certification;
	private int gradeLevel;
	private double wage;
	private double balance = 0;
	/**
	 * Constructor
	 * @param n is the name
	 * @param a is the age
	 * @param p is the phone number
	 * @param gl is the grade level this Teacher teachers
	 * @param c is a boolean if the Teacher has a teacher's certification
	 * @param w is the hourly wage
	 */
	public Teacher(String n, int a, int p, int gl, boolean c,double w){
		super(n,a,p);
		certification = c;
		gradeLevel = gl;
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
		String s = String.format("Name: %s\nAge: %d\nPhone: %d\nCertification: %b\nGrade Level: %d\nHourly Wage: $%f\nBalance: $%f\nEmployee ID: %d",name,age,phoneNumber,certification, gradeLevel, (float)wage,(float)balance,employeeID);
		return s;
	}
}
