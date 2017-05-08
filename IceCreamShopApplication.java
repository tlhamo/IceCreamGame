
import javax.swing.JFrame;
/**
 * Application class for the IceCreamShop 
 * @author Tseki
 *
 */
public class IceCreamShopApplication
{
  public static void main(String[] args)
  {
    JFrame iceFrame = new JFrame("Ice Cream Shop Game");
    
    iceFrame.setSize(700, 600);
    
    iceFrame.add(new IceCreamShop());
    
    iceFrame.setDefaultCloseOperation(3);
    
    iceFrame.setVisible(true);
  }
}