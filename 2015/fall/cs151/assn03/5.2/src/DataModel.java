import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A Subject class for the observer pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson
 Adapted from Object-Oriented Design & Patterns by Cay Horstmann

 @version 1.01 2015/10/25
 */
public class DataModel
{
   ArrayList<Double> data;
   ArrayList<ChangeListener> listeners;

   /**
      Constructs a DataModel object
      @param d the data to model
   */
   public DataModel(ArrayList<Double> d)
   {
      data = d;
      listeners = new ArrayList<ChangeListener>();
   }

   /**
      Constructs a DataModel object
      @return the data in an ArrayList
   */
   public ArrayList<Double> getData()
   {
      return (ArrayList<Double>) (data.clone());
   }

   /**
      Attach a listener to the Model
      @param c the listener
   */
   public void attach(ChangeListener c)
   {
      listeners.add(c);
   }

   /**
      Change the data in the model at a particular location
      @param location the index of the field to change
      @param value the new value
   */
   public void update(int location, double value)
   {
      data.set(location, new Double(value));
      for (ChangeListener l : listeners)
      {
         l.stateChanged(new ChangeEvent(this));
      }
   }
}