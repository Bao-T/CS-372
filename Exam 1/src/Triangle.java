
public class Triangle implements Shape {
	private static final String type = "Triangle";
	private int iD,side1,side2,side3;
	private String color;
	private double area,perimeter;
	public Triangle(int iD, int side1, int side2,int side3, String color){
		this.iD = iD;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.color = color;
		this.perimeter = side1+side2+side3;
		double p = perimeter/2;
		this.area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
		
	}
	public String toString(){
		return String.format("%s (ID#%d)", type,iD);
	}
	
	public String getKind(){return type;}
	public String getDetailString(){
		String details =  String.format("%s (ID#%d)", type,iD) +"\n" + String.format("Color: %s\nSide1: %d\nSide2: %d\nSide3: %d\nArea: %f\nPerimeter: %f\n", color,side1,side2,side3,area,perimeter);
		return details;
	}
	public int getID(){return iD;}
}
