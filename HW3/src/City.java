import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This Class models a city
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 */

public class City extends JComponent{
	/**
	 * Constructor initializes the city
	 */
	public City() {
		createCity();
	}
	
	private static Random rnd = new Random();
	private static ArrayList<Person> population = new ArrayList<Person>();
	private static ArrayList<Building> buildings = new ArrayList<Building>();
	
	
	
	
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
		buildings.add(new School("Doland Middle School","142 N. Anchor st."));
		buildings.add(new School("Apple High School","789 N. Life ave."));
		buildings.add(new Building("Lotus Temple","1 Centeroftheuniverse ave."));
		buildings.add(new Building("Cologne Cathedral","2 Centeroftheuniverse ave."));

		
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
			
			population.add(new Kid(String.format("Kid name %d", nameCount++),rnd.nextInt(19)+1,rnd.nextInt(9000000)+1000000, String.format("Favorit Candy %d", nameCount)));
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
	public String displayKidsInSchool(int index){
		String s= "";
		for(Person p: buildings.get(index).getOccupants()){
					if ( p instanceof Kid)
					{
						s += String.format("%s\n",p.getName());
					}
				}
			return s;	
			}
	/**
	 * Displays all Teachers in a Building's occupancy if the building is of type School
	 * @see School
	 * @see Building
	 * @see Teacher
	 */
	public String displayTeachersInSchool(int index){
		String s = "";
				for(Person p: buildings.get(index).getOccupants()){
					if ( p instanceof Teacher)
					{
						s += String.format("%s\n",p.getName());
					}
				}
			return s;	
			}
	/**
	 * Displays all Police in a Building's occupancy if the building is of type CityHall
	 * @see CityHall
	 * @see Building
	 * @see Teacher
	 */
	public String displayPoliceInCityHall(){
		String s= "";
		for (Building b:buildings){
			if (b instanceof CityHall)
			{
				for(Person p: b.getOccupants()){
					if ( p instanceof Police)
					{
						s += String.format("%s\n",p.getName());
					}
				}
				
			}
	}
		return s;
	}
	/**
	 * Iterates through the entire population, if a Person object is an instance of an Employee, pay that Person
	 * @see Person
	 * @see Employee
	 */
	public static void payEmployees(){
		for(Building b: buildings)
		{
			for (Person p: b.getOccupants()){
			if(p instanceof Employee)
			{
				((Employee)p).givePay();
				//System.out.printf("%s, Employee ID: %d, was paid $%f. Current Balance: $%f\n", p.getName(),((Employee)p).getID(),((Employee)p).getWage(),((Employee)p).getBalance());
			}
			}
		}
		
	}
	/**
	 * Gets the Buildings ArrayList
	 * @return buildings Array list
	 */
	public ArrayList<Building> getBuildings(){return buildings;}
	/**
	 * Gets the Population ArrayList
	 * @return Population Array list
	 */
	public ArrayList<Person> getPopulation(){return population;}
}
