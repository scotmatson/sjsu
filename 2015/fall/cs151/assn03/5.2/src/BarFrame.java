import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A class that implements an Observer object that displays a barchart view of
 a data model.

 Solves CS151 homework assignment #3

 @author Scot Matson
 Adapted from Object-Oriented Design & Patterns by Cay Horstmann

 @version 1.01 2015/10/25
 */
public class BarFrame extends JFrame implements ChangeListener
{
   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 200;

   private ArrayList<Double> a;
   private DataModel dataModel;

   /**
      Constructs a BarFrame object
      @param dataModel the data that is displayed in the barchart
   */
   public BarFrame(DataModel dataModel)
   {
      this.dataModel = dataModel;
      a = dataModel.getData();

      setLocation(0, 200);
      setLayout(new BorderLayout());

      Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }

         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);

            // Evenly distribute the total height amongst the number of elements.
            double barHeight = getIconHeight() / a.size();

            // Find the max value.
            double max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }

            // Distribute the width based upon the value of the longest bar.
            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();

               // Calculating the length of a bar.
               double barLength = getIconWidth() * value / max;

               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
      };

      // A listener for mouse events in the graph.
      MouseListener l = new MouseListener()
      {
         @Override
         public void mousePressed(MouseEvent e)
         {
            int x = e.getX();
            int y = e.getY();

            // Test value to print (x, y) coordinates in the console.
            System.out.println("(x, y) = (" + x + ", " + y + ")");

            if (x >= 0 && x <= ICON_WIDTH)
            {
               if (y >= 20 && y <= 69)
               {
                  dataModel.update(0, x);
               }
               if (y >= 70 && y <= 119)
               {
                  dataModel.update(1, x);
               }
               if (y >= 120 && y <= 169)
               {
                  dataModel.update(2, x);
               }
               if (y >= 170 && y <= 219)
               {
                  dataModel.update(3, x);
               }
            }
         }

         // Unused mouse events.
         @Override
         public void mouseClicked(MouseEvent e) {}
         @Override
         public void mouseReleased(MouseEvent e){}
         @Override
         public void mouseEntered(MouseEvent e){}
         @Override
         public void mouseExited(MouseEvent e){}
      };

      addMouseListener(l);
      add(new JLabel(barIcon));

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   /**
      Called when the data in the model is changed.
      @param e the event representing the change
   */
   public void stateChanged(ChangeEvent e)
   {
      // Retrieve the new values from the model.
      a = dataModel.getData();
      repaint();
   }
}