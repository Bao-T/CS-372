import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
public class Interface extends JFrame{
	private JPanel mainPane,Center,North,East,South,West;
	
	private JButton one,two,three,four,fix,six,lastButtonPressed,move,pay,currentBuildingPressed;
	
	private Person removed,currentPerson;
	private int currentBuildingIndex;
	private City c = new City();
	/**
	 * Runs the jFrame and initializes the interface
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Constructs the JFrame and the Interface UI
	 */
	public Interface(){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new BorderLayout(0, 0));
		Center = new JPanel();
		addBuilding(0, "resource/00-final-product.png");
		addBuilding(1, "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(2, "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(3, "resource/school-for-clip-art-di6e5dri9.jpeg");
		addBuilding(4, "resource/lotus_temple.jpg");
		addBuilding(5, "resource/we120249.jpg");
		pay = new JButton("Pay Current Employee");
		pay.setEnabled(false);
		Center.setBounds(0,0,50,50);
		mainPane.add(Center, BorderLayout.CENTER);
		Center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		East = new JPanel();
		//eastRepaint(0);
		West = new JPanel();
		westRepaint(0);
		
		
		JPanel options = new JPanel();

		pay.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	    			 if(currentPerson instanceof Employee)
	    			 {
	    				 ((Employee) currentPerson).givePay();
	    			 }
	    			 eastRepaint(currentBuildingIndex,currentPerson);
	    			
	    			 
			}
	     });
		JButton payall = new JButton("Pay All Employees");
			payall.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
		    			 c.payEmployees();
		    			 eastRepaint(currentBuildingIndex,currentPerson);
		    			
		    			 
				}
		     });
		options.add(pay);
		options.add(payall);
		
		mainPane.add(options, BorderLayout.SOUTH);
		options.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPane.add(East, BorderLayout.EAST);
		mainPane.add(West,BorderLayout.WEST);
		
	}
	
	/**
	 * repaints the East area of the borderLayout
	 * Data will show Building Data, and Building occupants
	 * @param buildingIndex is the index of the current building being displayed(Which building button was last selected)
	 */
	public void eastRepaint(int buildingIndex){
		currentBuildingIndex = buildingIndex;
		East.removeAll();
		int kidc = 0, teacherc = 0, policec=0;
		for (Person x: c.getBuildings().get(buildingIndex).getOccupants()){
			if (x instanceof Kid)
				kidc++;
			if (x instanceof Police)
				policec++;
			if (x instanceof Teacher)
				teacherc++;
				
		}
		String text = String.format("%s\n%s\nOccupants: %d\nPolice in Building: %d\nKids in Building: %d\nTeachers in Building: %d",c.getBuildings().get(buildingIndex).getName(),c.getBuildings().get(buildingIndex).getAddress(),c.getBuildings().get(buildingIndex).getOccupants().size(),policec,kidc,teacherc);
		JTextPane data = new JTextPane();
		data.setText(text);
		data.setEditable(false);
		East.add(data);
		East.revalidate();
		East.repaint();
		
	}
	/**
	 * repaints the East area of the borderLayout
	 * Data will show Building Data, and Building occupants
	 * If there is a selection in JList in West area, East will also display that person's data
	 * @param buildingIndex is the index of the current building being displayed(Which building button was last selected)
	 * @param p is the person being selected from the JList in the West area
	 */
	public void eastRepaint(int buildingIndex, Person p){
		
		
		currentBuildingIndex = buildingIndex;
		currentPerson = p;
		East.removeAll();
		int kidc = 0, teacherc = 0, policec=0;
		for (Person x: c.getBuildings().get(buildingIndex).getOccupants()){
			if (x instanceof Kid)
				kidc++;
			if (x instanceof Police)
				policec++;
			if (x instanceof Teacher)
				teacherc++;
				
		}
		String text = String.format("%s \nOccupants: %d\nPolice in Building: %d\nKids in Building: %d\nTeachers in Building: %d",c.getBuildings().get(buildingIndex).getName(),c.getBuildings().get(buildingIndex).getOccupants().size(),policec,kidc,teacherc);
		JTextPane data = new JTextPane();
		data.setText(text);
		data.setEditable(false);
		East.add(data);
		
		String personData = new String(p.getData());
		JTextPane pData = new JTextPane();
		pData.setText(personData);
		pData.setEditable(false);
		East.add(pData);
		East.setLayout(new BoxLayout(East,BoxLayout.Y_AXIS));
		East.revalidate();
		East.repaint();
	}
	/**
	 * Repaints the West Panel
	 * Implements move JButton, occupants in current selected building in JList with a JScrollPane, and a JLabel
	 * @param buildingIndex is the currently selected building(Which building button was last selected)
	 */
	public void westRepaint(int buildingIndex){

		West.removeAll(); // to reconstruct West every time this function is called
		//Creates a Label for occupants
		JLabel occupants = new JLabel();
		occupants.setText("Occupants:\n");
		West.add(occupants);
		//Creates a scrolling function for the JList peopleNames
		JScrollPane scrollPane;
		scrollPane = new JScrollPane();
		//Creates a JList of the occupants in the building
		JList<?> peopleNames = new JList(new Vector<Person>(c.getBuildings().get(buildingIndex).getOccupants()));
		peopleNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Creates a move Button to move occupants around buildings 
		move = new JButton("Move");
		move.setEnabled(false); // by default its disabled since the initial UI has no person selected
		
		//If User selects a person in JList
		peopleNames.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent le) {
		        int idx = peopleNames.getSelectedIndex(); // gets current selected index
		        if (idx != -1){
		        	//repaints East with the data of the person selected
		        	eastRepaint(buildingIndex,c.getBuildings().get(buildingIndex).getOccupants().get(idx));
		        	move.setEnabled(true); // move button is enabled once a person is selected
		        	//Enables pay if an employee is selected
		        	if(!(c.getBuildings().get(buildingIndex).getOccupants().get(idx) instanceof Employee))
		        		pay.setEnabled(false);
		        	else
		        		pay.setEnabled(true);
		        	
		        }
		        
		    	      
			}
         });
		
		//Allows JList to display the names of the Occupants
		peopleNames.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Person) {
                    // Here value will be of the Type 'CD'
                    ((JLabel) renderer).setText(((Person) value).getName());
                }
                return renderer;
            }
        });
		//If move is pressed, remove the selected person form the Current Building's occupants and disable JList area to be selected
		move.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == move)
				{
					lastButtonPressed = (JButton) e.getSource(); //used for when building buttons are pressed, can keep track of multiple button combos
					int idx = peopleNames.getSelectedIndex();
					removed = c.getBuildings().get(buildingIndex).getOccupants().remove(idx);
					peopleNames.enable(false);
					
				}
	    			 
	    			 
			}
	     });
		
		scrollPane.setViewportView(peopleNames);
		West.add(scrollPane);
		West.add(move);
		West.setLayout(new BoxLayout(West, BoxLayout.Y_AXIS));
		West.revalidate();
		West.repaint();
		
	}
	/**
	 * adds building buttons to the Center Area of the borderLayout JFrame
	 * @param nameIndex is the building index in the buildings ArrayList
	 * @param destination is the address of the picture used for the button
	 */
	public void addBuilding (int nameIndex,String destination) {

		try {
			 //Sets up the icon picture for the buttons
		      Toolkit toolkit = Toolkit.getDefaultToolkit();
		     URL imgUrl = getClass().getResource(destination);
		     Image img = toolkit.getImage(imgUrl);
		     img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		     ImageIcon icon = new ImageIcon(img);
		     JButton btn = new JButton(icon);
		     
		     //When a button is pressed
		     btn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					//Checks if move button was previously pressed
					//Doesn't update to the building that is selected
					//Shows data of building before move button was clicked
					if(lastButtonPressed == move){
						c.getBuildings().get(nameIndex).getOccupants().add(removed);
		    			 westRepaint(currentBuildingIndex);
		    			 eastRepaint(currentBuildingIndex);
		    			 lastButtonPressed.removeAll();
		    			 pay.setEnabled(false);
					}
					//Update the buildings buttons and repaints the East and West with new data from selected building
					else
					{	
						if(currentBuildingPressed != btn)
						{
							currentBuildingPressed.setBackground(null);
						}
						
						currentBuildingPressed = (JButton) e.getSource();
						currentBuildingPressed.setBackground(Color.yellow);
						westRepaint(nameIndex);
		    			 eastRepaint(nameIndex);
		    			 pay.setEnabled(false);
					}
				}
		     }
		    
		    		 );
		     
		     
		  
		     currentBuildingPressed = btn;
		     
		     btn.setToolTipText(c.getBuildings().get(nameIndex).getName());
		     Center.add(btn);
		   } catch (Exception ex) {;}
	}



}
