import javax.swing.*;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A class for testing an implementation of the MVC pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class MVCTester
{
   /**
    Constructor method for the MVCTester class.
    */
   public MVCTester()
   {
      String introText = "Enter text into the field below. " +
         "When you click the button or press enter it will be " +
         "added to this text area.\n\n";

      DataModel model = new DataModel(introText);
      DataView view = new DataView(model);
      model.register(view);
      DataController controller = new DataController(view, model);
      view.setVisible(true);
   }

   /**
    The main method.
    @param args user-defined arguments
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new MVCTester();
         }
      });
   }
}
