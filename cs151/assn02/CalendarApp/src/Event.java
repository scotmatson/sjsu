import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event
{
   private Date date; // This will be most important, can use as a reference for other information.
   private String title;
   private String description;
   // Should store an event
      // Date
      // Description
      // Title
   
   public Event(Date date, String title, String description)
   {
      this.date = date;
      this.title = title;
      this.description = description;
   }
}
