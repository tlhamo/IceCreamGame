import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class maintains the GUI view of just the Ice Cream Line which uses queues
 *  and implements the functionalities of the 
 * buttons such as add a random order and serve next order. 
 * @author Tseki
 *
 * 
 */
public class IceCreamLineManager<T> extends JPanel implements ActionListener{
	
	private JPanel buttonPanel;
	private JButton randOrder;
	private JButton serveOrder;
	private IceCreamLine  icl;
	
	public IceCreamLineManager() {
		super(new BorderLayout());
		icl = new IceCreamLine();		
		randOrder = new JButton("Add a random order");
		randOrder.addActionListener(this);
		serveOrder = new JButton("Serve the next order");
		serveOrder.addActionListener(this);
		buttonPanel = new JPanel();
		buttonPanel.setOpaque(true);
		buttonPanel.setBackground(Color.YELLOW); 
		buttonPanel.add(randOrder);
		randOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(serveOrder);
		serveOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.setLayout(new GridLayout(2,1));		
		add(buttonPanel, BorderLayout.NORTH);
		add(icl, BorderLayout.CENTER);				
	}
	
	/**
	 * Adds the functionalities of the random order button and serve button
	 * and updates the screen by repainting
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == randOrder){
			icl.addRandIceCream();
			validate();
	}else if(e.getSource() == serveOrder) {
		    icl.removeIceCream();
		    validate();
		}
	}
	

}
