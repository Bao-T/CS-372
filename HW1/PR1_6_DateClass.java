
public class PR1_6_DateClass {
	public static void main(String[] args)
	{
		Date currentDate = new Date(1,3,2017);
		currentDate.setDay(4);
		displayDate(currentDate);
	}
	public static void displayDate(Date d)
	{
		System.out.printf("%d/%d/%d",d.getDay(),d.getMonth(),d.getYear());
	}
}

class Date
{
	private int month,day,year;
	public Date(int m, int d, int y)
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