import java.util.Scanner;
public class PR1_4_BodyMassIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter your weight in pounds: ");
		int weight = scan.nextInt();
		System.out.printf("Enter your height in inches: ");
		int height = scan.nextInt();
		scan.close();
		double BMI = (weight*703)/(height*height);
		String BMIvalue = "NULL";
		System.out.printf("Your BMI value is: %f\n",BMI);
		
		if (BMI >= 30)
			BMIvalue = "Obese";
		else if (BMI >=25)
			BMIvalue = "Overweight";
		else if (BMI >= 18.5)
			BMIvalue = "Normal";
		else if (BMI <18.5)
			BMIvalue = "Underweight";
		System.out.printf("Your BMI value indicates you are %s.",BMIvalue);
		
	}

}
