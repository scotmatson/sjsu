import java.util.Date;

public class Event
{
   private Date start;
   private Date end;
   private String title;
   
   public Event(Date start, Date end, String title)
   {
      this.start = start;
      this.end = end;
      this.title = title;
   }
   
   /**
    * Returns the date of the event. Since events do not
    * current overlap days the source of the date does
    * not matter.
    * 
    * @return the date of the event.
    */
   public Date getDate()
   {
      return this.start;
   }
   
   /**
    * Returns the time at which the event begins.
    * 
    * @return the starting time of the event.
    */
   public Date getStartTime()
   {
      return this.start;
   }
   
   /**
    * Returns the time at which the event ends.
    * 
    * @return
    */
   public Date getEndTime()
   {
      return this.end;
   }
   
   /**
    * Returns the title of the event.
    * 
    * @return the event title.
    */
   public String getTitle()
   {
      return this.title;
   }
}
