

public class PR1_6_DateClass{
	private int month,day,year;
	public PR1_6_DateClass(int m, int d, int y)
	{
		month = m;
		day = d;
		year = y;
	}
	
	public int getMonth(){return month;}
	public int getDay(){return day;}
	public int getYear(){return year;}
	
	public void setMonth(int m){month = m;}
	public void setDay(int d){day = d;}
	public void setYear(int y){year = y;}
}