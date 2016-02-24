import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A class for testing the implementation of a slider.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class SliderTester
{
   final int MIN_WIDTH = 10;
   final int MAX_WIDTH = 500;
   final int STARTING_WIDTH = 100;

   JFrame frame = new JFrame("Car Slider");
   JSlider jSlider = new JSlider(JSlider.HORIZONTAL, MIN_WIDTH, MAX_WIDTH, STARTING_WIDTH);

   /**
    Constructor method for the SliderTester class.
    */
   public SliderTester()
   {
      JLabel jLabel = new JLabel(new CarIcon(STARTING_WIDTH));
      jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      frame.add(jLabel, BorderLayout.CENTER);

      Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
      labelTable.put(MIN_WIDTH, new JLabel("Small"));
      labelTable.put(MAX_WIDTH, new JLabel("Big"));
      jSlider.setLabelTable(labelTable);
      jSlider.setPaintLabels(true);
      jSlider.setMajorTickSpacing(10);
      jSlider.setPaintTicks(true);

      // Anonymous class implementation of a ChangeListener.
      jSlider.addChangeListener(new ChangeListener()
      {
         @Override
         public void stateChanged(ChangeEvent e)
         {
            JSlider source = (JSlider) e.getSource();
            jLabel.setIcon(new CarIcon(source.getValue()));
         }
      });

      frame.add(jSlider, BorderLayout.SOUTH);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   /**
    The main method.
    @param args User-defined arguments.
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new SliderTester();
         }
      });
   }
}
