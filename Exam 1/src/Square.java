
public class Square implements Shape {
	private static final String type = "Square";
	private int iD,side;
	private String color;
	private double area,perimeter;
	public Square(int iD, int side, String color){
		this.iD = iD;
		this.side = side;
		this.color = color;
		this.area = side*side;
		this.perimeter = 4*side;
	}
	public String toString(){
		return String.format("%s (ID#%d)", type,iD);
	}
	
	public String getKind(){return type;}
	public String getDetailString(){
		String details =  String.format("%s (ID#%d)", type,iD) +"\n" + String.format("Color: %s\nSide: %d\nArea: %f\nPerimeter: %f\n", color,side,area,perimeter);
		
		return details;
	}
	public int getID(){return iD;}
}
