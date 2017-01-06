/**
 * This Class is a Child Class of Person
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 */
public class Kid extends Person {
	String favoritCandy;
	/**
	 * 
	 * @param n is the name
	 * @param a is the age
	 * @param p is the phone number
	 * @param fC is the object's favoriteCandy
	 * @see Person
	 */
	public Kid (String n, int a, int p, String fC){
		super(n,a,p);
		favoritCandy = fC;
	}
	/**
	 * Returns the Kid's Specified favoritCandy
	 * @return the Kid's favoritCandy
	 */
	public String getFavoritCandy(){return favoritCandy;}
}
