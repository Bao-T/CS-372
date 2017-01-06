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
	public Building(String n, String a)
	{
		
		name = n;
		address = a;
	}
	public void addPeople(Person p){
		occupants.add(p);
	}
	public String getName(){return name;}
	public String getAddress(){return address;}
	public ArrayList<Person> getOccupants(){return occupants;}

}
