import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;
import java.net.URL;
public class MainUI {
static ArrayList<Object> shape = new ArrayList<Object>();
private static JTextPane txtShapeData;
private static JPanel Center;
private static JList<?> shapeList;
private static JLabel lblExampleShapeImage;

	public static void main(String[] args) {
		readData();
		JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        txtShapeData = new JTextPane();
		txtShapeData.setText("Shape Data:");
		frame.add(txtShapeData, BorderLayout.EAST);
		
		shapeList = new JList(new Vector<Object>(shape) );
		shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		shapeList.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent le) {
		        int idx = shapeList.getSelectedIndex(); // gets current selected index
		        if (idx != -1){
		        	txtShapeData.setText(((Shape)shape.get(idx)).getDetailString());
		        	txtShapeData.revalidate();
		        	txtShapeData.repaint();
		        	
		        	String destination = "";
		        	if (shape.get(idx) instanceof Circle)
		        		destination = "resource/Circle.png";
		        	else if (shape.get(idx) instanceof Square)
		        		destination = "resource/Square.png";
		        	else if (shape.get(idx) instanceof Rectangle)
		        		destination = "resource/Rectangle.png";
		        	else if (shape.get(idx) instanceof Triangle)
		        		destination = "resource/Triangle.png";
		        		
		        	
		        	
		        	
		        	
		        	 Toolkit toolkit = Toolkit.getDefaultToolkit();
				     URL imgUrl = getClass().getResource(destination);
				     Image img = toolkit.getImage(imgUrl);
				     img = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				     ImageIcon icon = new ImageIcon(img);
				     //lblExampleShapeImage = new JLabel(icon);
				     lblExampleShapeImage = new JLabel(icon);
				     Center.removeAll();
				     Center.add(lblExampleShapeImage);
				     Center.revalidate();
				     Center.repaint();
		        }
		        
		    	      
			}
         });
		
		shapeList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Object) {
                    // Here value will be of the Type 'CD'
                    ((JLabel) renderer).setText(((Object) value).toString());
                }
                return renderer;
            }
        });
		JScrollPane scrollPane;
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(shapeList);
		frame.add(scrollPane,BorderLayout.WEST);
		
		Center = new JPanel();
		
		
		lblExampleShapeImage = new JLabel("Example Shape Image");
		Center.add(lblExampleShapeImage);
		frame.add(Center, BorderLayout.CENTER);
		
        frame.setSize(1000,500);
        frame.setVisible(true);
	}
	
	public static void readData(){

				try(FileInputStream is = new FileInputStream("shapes.txt")){
					InputStreamReader ir = new InputStreamReader(is);
					BufferedReader rdr = new BufferedReader(ir);
					String line=rdr.readLine();
					
					while(line != null)
					{
					
						String[] parts = line.split(" ");
						
							if (parts[0].equals("circle:")){
								shape.add(new Circle(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]));
							}
							else if (parts[0].equals("square:")){
								shape.add(new Square(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),parts[3]));
							}
							else if (parts[0].equals("rectangle:")){
								shape.add(new Rectangle(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),parts[4]));
							}
							else if (parts[0].equals("triangle:")){
								shape.add(new Triangle(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),parts[5]));
							}
						
							
							line=rdr.readLine();
					}
					is.close();
					
			}catch (Exception e) {System.out.printf("%s",e);
	}

}
	}
