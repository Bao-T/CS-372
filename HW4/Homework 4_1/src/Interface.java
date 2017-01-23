import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * The Class is the main interface of the program and houses both DicePanel and Dice as JPanel and JLabels
 * @author Bao Tran
 * @version 1.00, 23 January 2017
 */
public class Interface extends JFrame{
	private Thread[] thread = new Thread[5];
	
	public static void main(String[] args) {
		Interface main = new Interface();

	}
	public Interface(){
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JButton btnStart = new JButton("Start");
		getContentPane().add(btnStart, BorderLayout.SOUTH);
		JLabel Sum = new JLabel("Sum");
		getContentPane().add(Sum, BorderLayout.NORTH);
		
		JPanel panel = new DicePanel();
		for (int i = 0; i < 5; i++)
		thread[i]= new Thread((Dice)(((DicePanel)panel).getDice().get(i)));
		
		btnStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (btnStart.getText().equals("Start"))
				{
				btnStart.setText("Stop");
				
				for (int i = 0; i < 5; i++)
					thread[i].start();
				
				}
				else
				{
				btnStart.setText("Start");
				for (int i = 0; i < 5; i++)
				{
					thread[i].interrupt();
					thread[i]= new Thread((Dice)(((DicePanel)panel).getDice().get(i)));
				}
				
				Sum.setText(String.format("Sum: %d", ((DicePanel)panel).getSum()));
				}
			}
		});
		
		
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setVisible(true);
		
		
		
	}

}
