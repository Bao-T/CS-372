import java.util.ArrayList;
import java.util.Random;
/**
 * This Class models a city
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 */

public class City {
	private static Random rnd = new Random();
	static ArrayList<Person> population = new ArrayList<Person>();
	static ArrayList<Building> buildings = new ArrayList<Building>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createCity();
		displayPopulation();
		displayBuildings();
		displayKidsInSchool();
		displayTeachersInSchool();
		displayPoliceInCityHall();
		payEmployees();
		payEmployees();
	}
	/**
	 * Adds buildings and creates a population for the city, adding them to the population and building ArrayLists
	 * @see Building
	 * @see Person
	 */
	public static void createCity(){
		/**
		 * Creates the buildings
		 * @see Building
		 */
		buildings.add(new CityHall("City Hall","123 Rain st."));
		buildings.add(new School("Homer Elementary","123 S. Rain st."));
		buildings.add(new School("Clay Elementary","78 E.Rockwood"));
		buildings.add(new School("Titan Elementary","2424 W. Road"));
		buildings.add(new School("Doland Middle School","142 N. Anchor st."));
		buildings.add(new School("Richman Middle School","4673 E. Central ave."));
		buildings.add(new School("Apple High School","789 N. Life ave."));
		buildings.add(new Building("Lotus Temple","1 Centeroftheuniverse ave."));
		buildings.add(new Building("Cologne Cathedral","2 Centeroftheuniverse ave."));
		buildings.add(new Building("Dome of the Rock","3 Centeroftheuniverse ave."));
		buildings.add(new Building("One World Trade Center","4 Centeroftheuniverse ave."));
		buildings.add(new Building("St Paul's Cathedral","5 Centeroftheuniverse ave."));
		buildings.add(new Building("Petronas Towers","6 Centeroftheuniverse ave.."));
		buildings.add(new Building("The White House","7 Centeroftheuniverse ave."));
		buildings.add(new Building("Leaning Tower of Pisa","8 Centeroftheuniverse ave."));
		
		/**
		 * Creates people in the city, adds them to population ArrayList
		 * @see Person
		 */
		int nameCount = 1;
		for (int i = 0; i <5; i++)
		{
			
			population.add(new Police(String.format("Police name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000,policeRoll.Captain,(double)rnd.nextInt(3000)/100+10));
			population.add(new Police(String.format("Police name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000,policeRoll.Chief,(double)rnd.nextInt(3000)/100+10));
			population.add(new Police(String.format("Police name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000,policeRoll.Patrol,(double)rnd.nextInt(3000)/100+10));
			population.add(new Police(String.format("Police name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000,policeRoll.Sargent,(double)rnd.nextInt(3000)/100+10));
		}
		nameCount = 1;
		for (int i = 0; i <30; i++)
		{
			population.add(new Teacher(String.format("Teacher name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000,rnd.nextInt(12)+1, rnd.nextInt(1)==1,(double)rnd.nextInt(3000)/100+10));
		}
		nameCount = 1;
		for(int i = 0; i < 100; i++)
		{
			
			population.add(new Kid(String.format("Kid name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000, String.format("Favorit Candy %d", nameCount)));
		}
		nameCount = 1;
		for (int i = 0; i <20; i ++)
		{
			population.add(new Person(String.format("Person name %d", nameCount++),rnd.nextInt(40)+20,rnd.nextInt(9000000)+1000000));
		}
		/**
		 * Randomly adds people in the population to buildings in the city
		 */
		for (int i = 0; i < population.size();i++)
		{
			buildings.get(rnd.nextInt(buildings.size())).addPeople(population.get(i));
		}
		
	}
	/**
	 * Displays the name of all people in the population of the city from the population ArrayList
	 */
	public static void displayPopulation()
	{
		System.out.println("Population:");
		for(Person p : population)
		{
			System.out.printf("%s,\n", p.getName());
		}
		
	}
	/**
	 * Displays all buildings in the city from the buildings ArrayList
	 */
	public static void displayBuildings()
	{
		System.out.println("Buildings:");
		for (Building b: buildings)
		{
			System.out.printf("%s,\n", b.getName());
			
		}
	}
	/**
	 * Displays all Kids in a Building's occupancy if the building is of type School
	 * @see School
	 * @see Building
	 * @see Kid
	 */
	public static void displayKidsInSchool(){
		for (Building b:buildings){
			if (b instanceof School)
			{
				for(Person p: b.getOccupants()){
					if ( p instanceof Kid)
					{
						System.out.printf("%s is at %s.\n",p.getName(),b.getName());
					}
				}
				
			}
	}
	}
	/**
	 * Displays all Teachers in a Building's occupancy if the building is of type School
	 * @see School
	 * @see Building
	 * @see Teacher
	 */
	public static void displayTeachersInSchool(){
		for (Building b:buildings){
			if (b instanceof School)
			{
				for(Person p: b.getOccupants()){
					if ( p instanceof Teacher)
					{
						System.out.printf("%s is at %s.\n",p.getName(),b.getName());
					}
				}
				
			}
	}
	}
	/**
	 * Displays all Police in a Building's occupancy if the building is of type CityHall
	 * @see CityHall
	 * @see Building
	 * @see Teacher
	 */
	public static void displayPoliceInCityHall(){
		for (Building b:buildings){
			if (b instanceof CityHall)
			{
				for(Person p: b.getOccupants()){
					if ( p instanceof Police)
					{
						System.out.printf("%s is at %s.\n",p.getName(),b.getName());
					}
				}
				
			}
	}
	}
	/**
	 * Iterates through the entire population, if a Person object is an instance of an Employee, pay that Person
	 * @see Person
	 * @see Employee
	 */
	public static void payEmployees(){
		for(Person p: population)
		{
			if(p instanceof Employee)
			{
				((Employee)p).givePay();
				System.out.printf("%s, Employee ID: %d, was paid $%f. Current Balance: $%f\n", p.getName(),((Employee)p).getID(),((Employee)p).getWage(),((Employee)p).getBalance());
			}
		}
	}
}
