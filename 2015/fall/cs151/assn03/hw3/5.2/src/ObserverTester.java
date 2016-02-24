import java.util.ArrayList;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A class for testing an implementation of the Observer pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson
 Adapted from Object-Oriented Design & Patterns by Cay Horstmann

 @version 1.01 2015/10/25
 */
public class ObserverTester
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      // Generates default data for the graph.
      ArrayList<Double> data = new ArrayList<Double>();
      data.add(new Double(33.0));
      data.add(new Double(44.0));
      data.add(new Double(22.0));
      data.add(new Double(22.0));

      // Updates the model with the data.
      DataModel model = new DataModel(data);

      // Display numerical data.
      TextFrame frame = new TextFrame(model);
      // Couple with data.
      model.attach(frame);

      // Display graphical data.
      BarFrame barFrame = new BarFrame(model);
      // Couple with data.
      model.attach(barFrame);
   }
}