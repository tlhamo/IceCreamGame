import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Creates the IceCreamShop that has both the line manager and the maker
 * 
 * @author Tseki
 *
 */

public class IceCreamShop extends JPanel {
	private IceCreamLine line;
	private IceCreamMaker maker;
	private JLabel scoreLabel;
	private int score;
	/**
	 * Constructor sets border layout, instantiates maker, adds order region
	 * which will contain the maker and adds panels like instruction
	 * Sets score to zero
	 */
	 public IceCreamShop()
	  {
	    super(new BorderLayout());
	    addOrderRegion();	    
	    this.maker = new IceCreamMaker();
	    add(this.maker, "Center");	    
	    addPanels();	    
	    this.score = 0;
	  }
	  
	 /*
	  * Creates the order region where the line of ice creams in created
	  */
	  private void addOrderRegion()  {
	    JPanel orderArea = new JPanel(new BorderLayout());
	    orderArea.add(makeRandomButton(), "South");    
	    this.line = new IceCreamLine();    
	    orderArea.add(this.line, "Center");	    
	    add(orderArea, "West");
	  }
	  
	  /**
	   * Creates the score panel, and top panel that contains serve button and instructions 
	   */
	  private void addPanels(){
	    JPanel topPanel = new JPanel(new GridLayout(2, 1));	    
	    JPanel statusPanel = new JPanel(new GridLayout(2, 1));
	    statusPanel.add(new JLabel("<html>Make ice cream cones to match the next order (at the top).<br>Every correct order served earns you 10 points.<br>Make the wrong cone and you'll lose 5 points.</html>"));
	    this.scoreLabel = new JLabel("Score: 0");
	    statusPanel.add(this.scoreLabel);
	    topPanel.add(statusPanel);
	    topPanel.add(makeServeButton());	    
	    add(topPanel, "North");
	  }
	  
	  /**
	   * Makes a button for generating a random ice cream
	   * @return the button so that the order region can add it to order Area
	   */
	  private JButton makeRandomButton(){
	    JButton randomButton = new JButton("Add a random order");
	    randomButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        IceCreamShop.this.line.addRandIceCream();
	      }
	    });
	    return randomButton;
	  }
	  
	  /**
	   * Creates the serve button and returns it
	   * @return serveButton
	   */
	  private JButton makeServeButton() {
	    JButton serveButton = new JButton("Serve the next order");
	    serveButton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e)
	      {
	        IceCreamShop.this.serve();
	      }
	    });
	    return serveButton;
	  }
	  
	  /**
	   * Creates a iceCreamCone from ice cream line class
	   * Creates a iceCreamCone from ice cream maker class 
	   * compares the two to check if flavors stacker are 
	   * in the same order.
	   * Adjusts score accordingly
	   */
	  public void serve() {
	    if (!this.line.isQueueEmpty())
	    {
	      IceCreamCone nextOrder = this.line.getNextOrder();	      
	      IceCreamCone currentCone = this.maker.getIceCreamCone();
	      if (isSame(nextOrder, currentCone)) {
	        score += 10;
	      } else {
	       score -= 5;
	      }
	      this.scoreLabel.setText("Score: " + Integer.toString(this.score));
	      //pops the scoop off the maker ice cream
	      this.maker.popMakerScoop();
	    }
	  }
	  /**
	   * Checks if the two ice creams have the same value 
	   * by looping through each cone and popping to check next one.
	   * @param iceCreamCone1 ice cream that is in line class
	   * @param iceCreamCone2 ice cream that is in maker class
	   * @return true or false if the cones are the same
	   */
	  public boolean isSame(IceCreamCone iceCreamCone1, IceCreamCone iceCreamCone2)
	  {
	    while (!iceCreamCone1.emptyScoop())
	    {
	      if (iceCreamCone2.emptyScoop()) {
	        return false;
	      }
	      if (!iceCreamCone1.popTopScoop().equals(iceCreamCone2.popTopScoop())) {
	        return false;
	      }
	    }
	    return iceCreamCone2.emptyScoop();
	  }
	}