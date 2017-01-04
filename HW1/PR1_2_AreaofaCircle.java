import java.util.Scanner;
public class PR1_2_AreaofaCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double PI = 3.14;
		System.out.printf("Enter the radius for a circle: ");
		Scanner scan = new Scanner(System.in);
		double radius = scan.nextDouble();
		scan.close();
		System.out.printf("Circle area: %f units^2.", PI*radius*radius);
	}

}
