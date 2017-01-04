
public class PR1_6_DateClassTest {

	public static void main(String[] args) {

		PR1_6_DateClass currentDate = new PR1_6_DateClass(1,3,2017);
			currentDate.setDay(4);
			displayDate(currentDate);
		}
		public static void displayDate(PR1_6_DateClass d)
		{
			System.out.printf("%d/%d/%d",d.getDay(),d.getMonth(),d.getYear());
		}

}
