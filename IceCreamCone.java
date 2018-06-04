import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Maintains a stack of ice cream scoop flavors using the class you just
 * created. Implements the functionality of an Ice cream cone and provides 
 * 4 flavors of icecreams. Has two versions of a method addScoop for adding a scoop to the top
 * of the cone: one that takes a String indicating the flavor to be added, and
 * one that takes no arguments and adds a scoop of a random flavor.
 * 
 * @author Tseki
 * 
 *
 */
public class IceCreamCone<T> extends JComponent {
	private StackLL<String> stack;
	private int counter;
	private static final int DIAM = 30;
	private static final int CONE_X_OFFSET = 70;
	private static final int CONE_Y_OFFSET = 30;
	
	public IceCreamCone() {
		stack = new StackLL<String>();
	}

	/**
	 * Add's a scoop on stack
	 * 
	 * @param scoop adds this scoop
	 */
	public void addScoop(String scoop) {			
		stack.push(scoop);
		validate();
		repaint();
	}
	
	/**
	 * Removes the scoop by popping it off the stack
	 */
	public void removeScoop() {
		stack.pop();
		validate();
		repaint();
	}

	/**
	 * Adding random scoops on cone by generating a random number from 1 to 4
	 */
	public void addRandScoop() {
		int max = 4;
		int min = 1;
		int randNum = min + (int) (Math.random() * max);
		if (randNum == 1) {
			stack.push("vanilla");	
		} else if (randNum == 2) {
			stack.push("strawberry");
		} else if (randNum == 3) {
			stack.push("greenTea");
		} else if (randNum == 4) {
			stack.push("burntCaramel");
			}
		validate();
		repaint();		
		}
	/**
	 * Calls paintallscoops and paintcone
	 * @param g graphics obj
	 */
	public void paint(Graphics g){
		paintCone(g);
		paintAllScoops(g);
			
		}
	
	/**
	 * Checks if this stack is empty
	 * @return  if stack is empty or not
	 */
	 public boolean emptyScoop()
	  {
	    return stack.isEmpty();
	  }
	
	 /**
	  * Pops the scoop off ice cream and returns the flavor value of the scoop
	  * @return scoop popped
	  */ 
	 public String popTopScoop()
	  {
	    if (!stack.isEmpty()) {   
	    return  stack.pop();
	    }
	    return null;
	  }
	
	 /**
	  * Creates a temporary stack that contains the upside down values of the stack
	  * Calls peeks through the tempStack and prints the scoop flavor according to 
	  * the flavor when peeked 
	  * @param g .
	  */
	public void paintAllScoops(Graphics g){	
		counter = 1;
		StackLL<String> tempStack = new StackLL<String>();
		//position value for the drawing of scoops 
		int currentX = (getWidth() / 2) - 75;     
		//Update counter so that the height of scoop gets pushed higher 
	    while (!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		//while the stack is not empty
	    while(!tempStack.isEmpty()){  
	    	int currentY = getHeight() - 30 - getScoopHeight(counter);
	    	counter++;
	    	
			if (tempStack.peek() == "vanilla") {
				g.setColor(Color.WHITE);
				g.fillOval(currentX, currentY, DIAM, DIAM);
				stack.push(tempStack.pop());
				
			} else if (tempStack.peek() == "strawberry") {
				g.setColor(Color.PINK);
				g.fillOval(currentX, currentY , DIAM, DIAM);
				stack.push(tempStack.pop());
				
			} else if (tempStack.peek() == "greenTea") {
				g.setColor(new Color(193, 255, 182));
				g.fillOval(currentX, currentY , DIAM, DIAM);
				stack.push(tempStack.pop());
				
			} else if (tempStack.peek() == "burntCaramel") {
				g.setColor(Color.ORANGE);
				g.fillOval(currentX, currentY, DIAM, DIAM);
				stack.push(tempStack.pop());
			}
			}	    	
 
	}
	
	/**
	 * Paints the cone 
	 * @param g graphics object 
	 */
	public void paintCone(Graphics g){
		g.setColor(new Color(221, 191, 120));
		g.fillPolygon(new int[] { (getWidth() / 2) - CONE_X_OFFSET, (getWidth() / 2) - CONE_X_OFFSET + 10, (getWidth() / 2) - CONE_X_OFFSET + 20 }, 
					  new int[] { getHeight()-CONE_Y_OFFSET , getHeight(), getHeight()-CONE_Y_OFFSET  }, 3);
	}

	/**
	 * Calculates the offset of the next scoop to be 
	 * @param counter indicates the amount of scoops on the cone and 
	 * changes the y height accordingly
	 * @return y value
	 */
	public int getScoopHeight(int counter) {
		int y = ((DIAM - 10) * counter);
		return y;
	}
	
}
