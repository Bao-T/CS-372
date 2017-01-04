
public class PR1_3_IntegerValueofaCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char characters[] = {'A','B','C','a','b','c','0','1','2','$','^','+','/',' '};
		for (char c:characters)
			System.out.printf("The character %c has the value %d.\n",c,(int)c );
		
	}

}
