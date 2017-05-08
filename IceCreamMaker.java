import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The IceCreamMaker class controls the GUI display and calls methods for 
 * adding scoops one at a time and gives the ability to choose scoop flavors
 * and trash scoops
 * 
 * @author Tseki
 * Date: 4th April 
 *
 */

public class IceCreamMaker<T> extends JPanel implements ActionListener{
	private JButton vanilla, strawberry, greenTea, burntCaramel,trash;
	private JPanel buttonPanel;
	private IceCreamCone<String>  icc;
	
	//Creates all the buttons for the IceCream Maker and adds action listeners to them
	public IceCreamMaker(){
		super(new BorderLayout());
		icc = new IceCreamCone<String>();
				
		vanilla = new JButton("vanilla");
		vanilla.addActionListener(this);
		vanilla.setBackground(Color.WHITE);
		vanilla.setContentAreaFilled(false);
        vanilla.setOpaque(true);
        vanilla.setBorderPainted(false);
		
        strawberry = new JButton("strawberry");
		strawberry.addActionListener(this);
		strawberry.setBackground(Color.PINK);
		strawberry.setContentAreaFilled(false);
        strawberry.setOpaque(true);
        strawberry.setBorderPainted(false);

		greenTea = new JButton("green tea");
        greenTea.addActionListener(this);
		greenTea.setBackground(new Color(193,255,182));
		greenTea.setContentAreaFilled(false);
		greenTea.setOpaque(true);
		greenTea.setBorderPainted(false);
		
		burntCaramel = new JButton("burnt caramel");
		burntCaramel.addActionListener(this);
		burntCaramel.setBackground(Color.ORANGE);
		burntCaramel.setContentAreaFilled(false);
		burntCaramel.setOpaque(true);
		burntCaramel.setBorderPainted(false);
		
		trash = new JButton("Trash the top scoop");
		trash.addActionListener(this);
		trash.setBackground(Color.GRAY);
		trash.setContentAreaFilled(false);
		trash.setOpaque(true);
		trash.setBorderPainted(false);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0,4));
		buttonPanel.add(vanilla);
		buttonPanel.add(strawberry);		
		buttonPanel.add(greenTea);
		buttonPanel.add(burntCaramel);
		buttonPanel.add(trash);
			
		add(buttonPanel, BorderLayout.NORTH);
		add(icc, BorderLayout.CENTER);
	}
	
	/**
	 * Calls add scoop method when a flavor button is pressed 
	 * and deletes scoop when trash button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vanilla){
			icc.addScoop("vanilla");
		}else if(e.getSource() == strawberry){
			icc.addScoop("strawberry");
		}else if(e.getSource() == greenTea){
			icc.addScoop("greenTea");
		}else if(e.getSource() == burntCaramel){
			icc.addScoop("burntCaramel");
		}else if(e.getSource() == trash){
			icc.removeScoop();
		}
		
	}
	
	/**
	 * Returns the icc cream cone that is being manipulated 
	 * @return icc
	 */
	public IceCreamCone getIceCreamCone()
	  {
	    return icc;
	  }
	
	/**
	 * Pops the ice cream scoop from the ice cream maker region
	 */
	public void popMakerScoop(){
	    while (!icc.emptyScoop()) {
	      icc.popTopScoop();
	    }
	    validate();
	    icc.repaint();
	  }
}
