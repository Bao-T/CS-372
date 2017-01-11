import java.util.ArrayList;
/**
 * This Class is the Parent class of CityHall and School
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 * @see CityHall 
 * @see School 
 */
public class Building {
	private String name;
	private String address;
	private ArrayList<Person> occupants = new ArrayList<Person>();
	/**
	 * Constructor
	 * @param n is the name of the building
	 * @param a is the address of the building
	 */
	public Building(String n, String a)
	{
		name = n;
		address = a;
	}
	/**
	 * Function adds Person objects to occupants ArrayList
	 * @param p is the person wanting to be added
	 */
	public void addPeople(Person p){
		occupants.add(p);
	}
	/**
	 * Gets building name
	 * @return gives the name of the building
	 */
	public String getName(){return name;}
	/**
	 * Gets building's address
	 * @return gives the address of the building
	 */
	public String getAddress(){return address;}
	/**
	 * Allows access to the occupants Arraylist
	 * @return the Occupants
	 */
	public ArrayList<Person> getOccupants(){return occupants;}

}
