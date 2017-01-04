import java.util.Scanner;
public class PR1_1_OddorEven {

	public static void main(String[] args) {
		System.out.printf("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.printf("%d is ", n);
		if(n%2 == 0)
			System.out.printf("even.");
		else
		{
			System.out.printf("odd.");
		}

	}

}
