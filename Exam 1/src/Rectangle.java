
public class Rectangle implements Shape {
	private static final String type = "Rectangle";
	private int iD,length,width;
	private String color;
	private double area,perimeter;
	public Rectangle(int iD, int length,int width, String color){
		this.iD = iD;
		this.length = length;
		this.width = width;
		this.color = color;
		this.area = length*width;
		this.perimeter = 2*length + 2*width;
	}
	public String toString(){
		return String.format("%s (ID#%d)", type,iD);
	}
	
	public String getKind(){return type;}
	public String getDetailString(){
		String details =  String.format("%s (ID#%d)", type,iD) +"\n" + String.format("Color: %s\nLength: %d\nWidth: %d\nArea: %f\nPerimeter: %f\n", color,length,width,area,perimeter);
		return details;
	}
	public int getID(){return iD;}
}
