import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A model class that stores and maintains the state of data in an MVC pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class DataModel
{
   String data;
   ChangeListener listener;

   /**
    Constructor method for the DataModel class.
    @param str the String to store
    */
   public DataModel (String str)
   {
      data = str;
   }

   /**
    Returns the currently stored String value.
    @return a String
    */
   public String getText()
   {
      return data;
   }

   /**
    Registers a ChangeListener so classes may be notified when data has
    been modified.
    @param c a ChangeListener
    */
   public void register(ChangeListener c)
   {
      listener = c;
   }

   /**
    Updates the current data being modelled
    @param str a String
    */
   public void update(String str)
   {
      this.data = str;
      listener.stateChanged(new ChangeEvent(this));
   }
}
