import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
/**
 * Images used to represent the Dice that are in the DicePanel JPanel
 * @author Bao Tran
 * @version 1.00, 23 January 2017
 */
public class Dice extends JLabel implements Runnable {
	private int value;
	private ImageIcon[] icon = new ImageIcon[6];
	/**
	 * Constructor
	 * Sets up the dice icons initially
	 */
	public Dice()
	{
		for (int i = 0; i < 6; i ++)
		{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL imgUrl = getClass().getResource(String.format("resources/%d.png", i+1));
			Image img = toolkit.getImage(imgUrl);
			img = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			icon[i] = new ImageIcon (img);
		}
		
		Random rnd = new Random();
		value = rnd.nextInt(6)+1;
		setIcon(icon[value-1]);
	}
	
	/**
	 * Creates the thread.
	 * Changes the value and icon of the specified dice.
	 */
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
		    try{        
		    	Random rnd = new Random();
				value = rnd.nextInt(6)+1;
				setIcon(icon[value-1]);
				Thread.sleep(10* (rnd.nextInt(10)+1));
		    }
		    catch(InterruptedException e){
		        Thread.currentThread().interrupt();
		        break; 
		    }
		    catch(Exception e){
		        e.printStackTrace();
		        
		    }
	}
	}
	/**
	 * Returns the Dice's value for calculating the sum
	 * @return value;
	 */
	public int getValue(){return value;}
}

