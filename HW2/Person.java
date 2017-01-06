/**
 * This class is the Parent class of Police, Teacher, and Kid
 * @see Kid
 * @see Police
 * @see Teacher
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 */
public class Person {
	private String name;
	int age,phoneNumber;
	int employeeID = 0;
	static int currentIDCount = 100000000;
	/**
	 * Constructor
	 * @param n is the name
	 * @param a is the age
	 * @param p is the phone number
	 */
	public Person(String n,int a, int p){
		name = n; age = a; phoneNumber = p;
	}
	/**
	 * Returns the person's name
	 * @return name
	 */
	public String getName(){return name;}
}
