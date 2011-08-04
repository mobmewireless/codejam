import javax.swing.*;
import java.awt.*;

// @author: Syam Sankar
// This class draws the Indian national Flag- Indian Tricolor
public class indian_tricolour
{
  public static void main(String[] args) 
  {
     new indian_tricolour();
  }

  public indian_tricolour()
  {
    JFrame frame = new JFrame("Indian Tricolor");           // Setting the name of the frame(will be displayed in the top bar of window)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // So that the window closes on pressing the close button
    frame.getContentPane().add(new FlagComponent());        // At default the component will be place at the center of the frame.
    frame.setSize(900,630);                                 // Setting the size of the frame.
    frame.setVisible(true);  
  }

  public class FlagComponent extends JComponent
  {
      public void paint(Graphics g)
      {
          int height1 = 1300;                               
          int width1 = 1300;
          Graphics2D g2d = (Graphics2D)g;
          g2d.setColor(Color.black);  
          g2d.fillRect(0,0,height1,width1);                       // To give a black background around the flag when the window is maximised.
          
          height1 = 900;
          width1 = 200;
          Color saffron = new Color(255, 153, 51);              // Mixing the original saffron color.
          g2d.setColor(saffron);          
          g2d.fillRect(0,0,height1,width1);                       //  Setting the Saffron Rectangle
          g2d.setColor(Color.white);
          g2d.fillRect(0,200,height1,width1);                     // Setting the white middle rectangle
          Color darkblue = new Color(25,25,112);

          Color green = new Color(0,128,0);                     // Mixing the original green color of the Indian Flag.
          g2d.setColor(green);            
          g2d.fillRect(0,400,height1,width1);                   // Setting the green rectangle



          
          g2d.setColor(darkblue);
          g2d.fillOval (380,210,180, 180);                        // Drawing the blue Chakra
          g2d.setColor(Color.white);
          g2d.fillOval (385,215,170,170);           //For designing concentric circles (differnce of size)/2 will be added to the x,y of smaller circle!  

          g2d.setColor(darkblue);
          g2d.fillOval (455,285,30,30);
          Rectangle rect = new Rectangle(470,300,85,4); 
          g2d.fill(rect);
          for(int i = 0 ; i < 24 ; i++)
          {
              g2d.translate(470,300);
              g2d.rotate(Math.PI/12.0);      
              g2d.translate(-470,-300);
              rect = new Rectangle(470,300, 85, 4);
              g2d.fill(rect);          
          }       
     }
  }
}
