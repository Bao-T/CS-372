
public class Circle implements Shape {
	private static final String type = "Circle";
	private int iD,radius;
	private String color;
	private double area,circumference;
	private static final double PI = 3.14;
	public Circle (int iD, int radius, String color ){
		this.iD = iD;
		this.radius = radius;
		this.color = color;
		this.area = PI*radius*radius;
		this.circumference = 2*PI*radius;
	}
	
	
	public String toString(){
		return String.format("%s (ID#%d)", type,iD);
	}
	
	public String getKind(){return type;}
	public String getDetailString(){
		String details =  String.format("%s (ID#%d)", type,iD) +"\n" + String.format("Color: %s\nRadius: %d\nArea: %f\nCircumference: %f\n", color,radius,area,circumference);
		
		return details;
	}
	public int getID(){return iD;}
}
