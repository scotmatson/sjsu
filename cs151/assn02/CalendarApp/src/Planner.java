import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

enum MONTHS {
   Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}

enum DAYS {
   Sun, Mon, Tue, Wed, Thur, Fri, Sat;
}

public class Planner
{  
   // Constants
   private final String EVENTS_FILE;
   private final char DAY_VIEW = 'd';
   private final char MONTH_VIEW = 'm'; // Default
   
   // Mutable
   private int view;
   private List<Event> events;
 
   // Calendar stuff.
   Calendar calendar;
   MONTHS[] arrayOfMonths = MONTHS.values();
   DAYS[] arrayOfDays = DAYS.values();
   
   
   /**
    * Constructor method.
    */
   public Planner(String filename, Calendar calendar)
   {
      this.EVENTS_FILE = filename;
      this.view = MONTH_VIEW;
      this.events = new ArrayList<>();
      
      // Default calendar set for 'today'.
      this.calendar = calendar;
   }
   public void loadEvents()
   {
      // Load events from the file
      // and turn them into objects
      try 
      {
         BufferedReader br = new BufferedReader(new FileReader(EVENTS_FILE));
      }
      catch (FileNotFoundException fnfe)
      {
         System.out.printf("%s", "Unable to locate events.txt.");
      }
      
   }
   
   public void toggleView()
   {

   }
   
   public void createEvent(Date date, String title, String description)
   {
      Event e = new Event(date, title, description);
   }
   
   public void goToEvent()
   {
      
   }
   
   public void listEvents()
   {
      
   }
   
   public void deleteEvent()
   {
      
   }

   public void saveEvents()
   {
      // Write events to events.txt
   }
   
   
   public void printCalendar()
   {
      
   }
}
