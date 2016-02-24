import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A controller class to process user interactions in an MVC pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class DataController
{
   private DataView view;
   private DataModel model;

   /**
    A constructor method for the DataController class.
    @param view a view to monitor
    @param model a model to update
    */
   public DataController(DataView view, DataModel model)
   {
      this.view = view;
      this.model = model;

      view.addButtonListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            String inputText = view.getText();
            view.clearInput();
            view.setFocus();

            model.update(inputText);
         }
      });
   }
}
