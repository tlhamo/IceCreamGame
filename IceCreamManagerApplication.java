

import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * Application for the Ice Cream Line Manager
 * @author Tseki
 *
 */
public class IceCreamManagerApplication
{
  public static void main(String[] args)
  {
    JFrame iceFrame = new JFrame("Ice Cream Line Manager");
    
    iceFrame.setSize(500, 600);
    
    iceFrame.add(new IceCreamLineManager());
    
    iceFrame.setDefaultCloseOperation(3);
    
    iceFrame.setVisible(true);
  }
}