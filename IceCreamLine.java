import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * IceCreamLine class makes the queue for each ice cream
 * 
 * @author Tseki
 *
 * @param <T> type is IceCreamCone here
 */
public class IceCreamLine<T> extends JComponent{
	private QueueLL<IceCreamCone> iceCreamQueue;
	private IceCreamCone<String> icc;
	private IceCreamCone<String> iccMain;
	
	public IceCreamLine(){
		iceCreamQueue = new QueueLL<IceCreamCone>();
		this.setVisible(true);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
	}
	
	/**
	 * Generates a random number which is used for scoop number and scoop flavor
	 * @return randNum
	 */
	public int randNum(){
		int max = 4;
		int min = 1;
		int randNum = min + (int) (Math.random() * max);
		return randNum;
	}
	
	/**
	 * Adds a random selection of scoops and scoop number
	 */
	public void addRandIceCream(){
		icc = new IceCreamCone<String>();
		int scoopAmount = randNum();
		iceCreamQueue.enqueue(icc);	
		//scoopAmount is a random number that indicates how many scoops should be created
		for(int i = 0; i< scoopAmount; i++){
			icc.addRandScoop();	
			validate();
			repaint();
			}
		
		this.add(icc);
		
	}
	
	/**
	 * Stores the nextOrder which is dequeued in an object 
	 * @return nextOrder which is the dequeued iceCream
	 */
	 public IceCreamCone getNextOrder()
	  {
	    IceCreamCone nextOrder = iceCreamQueue.dequeue();
	    if (nextOrder != null)
	    {
	      remove(nextOrder);      
	      this.validate();
	      this.repaint();
	    }
	    return nextOrder;
	  }
	
	/**
	 * Removes the whole iceCream from the queue and updates screen
	 */
	public void removeIceCream(){
		if(!iceCreamQueue.isEmpty()){
		remove(iceCreamQueue.dequeue());
		this.validate();
		this.repaint();
		}
	}
	/**
	 * Checks if queue is empty
	 * @return true or false if iceCreamQueue  is empty
	 */
	public boolean isQueueEmpty() {
		return iceCreamQueue.isEmpty();
		}
}
