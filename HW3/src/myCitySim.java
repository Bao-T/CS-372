import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class myCitySim extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	City c = new City();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myCitySim frame = new myCitySim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public myCitySim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMyCitySimulator = new JLabel("My City Simulator");
		contentPane.add(lblMyCitySimulator, BorderLayout.NORTH);
		
		panel = new JPanel();
		addBuilding(c.getBuildings().get(0).getName(), "resource/00-final-product.png");
		addBuilding(c.getBuildings().get(1).getName(), "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(c.getBuildings().get(2).getName(), "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(c.getBuildings().get(3).getName(), "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(c.getBuildings().get(4).getName(), "resource/lotus_temple.jpg");
		addBuilding(c.getBuildings().get(5).getName(), "resource/we120249.jpg");
		
		panel.setBounds(0, 0, 50, 50);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
	
		
		JTextArea occupants = new JTextArea();
		occupants.setText("Occupants:\n");
		contentPane.add(occupants, BorderLayout.WEST);
		
		JPanel options = new JPanel();
		options.add(new JButton("Pay Employees"));
		options.add(new JButton("Pay Employees"));
		options.add(new JButton("Pay Employees"));
		contentPane.add(options, BorderLayout.SOUTH);
		options.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblData_1 = new JLabel("Occupant Data:\n");
		contentPane.add(lblData_1, BorderLayout.EAST);
	}
	public void addBuilding(String name,String destination){
		try {
		      Toolkit toolkit = Toolkit.getDefaultToolkit();
		     URL imgUrl = getClass().getResource(destination);
		     Image img = toolkit.getImage(imgUrl);
		     img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		     ImageIcon icon = new ImageIcon(img);
		     JButton btn = new JButton(icon);
		     btn.setToolTipText(name);
		     panel.add(btn);
		   } catch (Exception ex) {;}
	}

}
