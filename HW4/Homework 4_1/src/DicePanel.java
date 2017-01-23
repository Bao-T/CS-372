import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class represents the main panel that contains the Dice Objects
 * @author Bao Tran
 * @version 1.00, 23 January 2017
 */
public class DicePanel extends JPanel {
	private ArrayList <JLabel> dice = new ArrayList<JLabel>();
	/**
	 * Constructor uses Dice
	 * @see Dice
	 * Creates a list of created dice.
	 */
	public DicePanel()
	{
		for (int i = 0; i < 5; i ++){
			dice.add(new Dice());
			add(dice.get(i));
		}
	}
	/**
	 * Gets the sum
	 * @see Dice
	 * @return the sum of all dice values added together
	 */
	public int getSum(){
		int total = 0;
		for (int i = 0; i < 5; i++)
		{
			total += ((Dice)dice.get(i)).getValue();
		}
		return total;
	}
	public ArrayList <JLabel> getDice(){return dice;}
	
	

}
