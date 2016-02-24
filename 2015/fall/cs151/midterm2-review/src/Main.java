import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Main {

   public Main()
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ShapeComponent shape = new ShapeComponent();

      frame.add(shape);
      frame.pack();
      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
      System.out.println("Season: " + Seasons.FALL);
      System.out.println("Temperature: " + Seasons.FALL.getTemperature());

      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new Main();
         }
      });
   }
}

class ShapeComponent extends JComponent
{
   Ellipse2D circle;
   Color c;

   ShapeComponent()
   {
      circle = new Ellipse2D.Double((500-100)/2, (500-100)/2, 100, 100);
      c = Color.BLACK;

      this.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mousePressed(MouseEvent e)
         {
            if(circle.contains(e.getPoint()))
            {
               if (c.equals(Color.BLUE))
               {
                  c = Color.BLACK;
               }
               else
               {
                  c = Color.BLUE;
               }
               repaint();
            }
         }
      });
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(500, 500);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      g2.setColor(c);
      g2.fill(circle);
   }
}
