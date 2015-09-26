import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

enum View {
   MONTH, DAY;
}

public class Planner
{  
   private final String EVENTS_FILE;
   Calendar calendar;
   private View view;
   private List<Event> events;

   public Planner(Calendar calendar)
   {
      this.EVENTS_FILE = "events.txt";
      this.view = View.MONTH;
      this.events = new LinkedList<>();
      
      // Default calendar set for 'today'.
      this.calendar = calendar;
   }
   
   /**
    * Constructor method.
    */
   public Planner(Calendar calendar, String filename)
   {
      this.EVENTS_FILE = filename;
      this.view = View.MONTH;
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
   
   public void addEvent(Date start, Date end, String title)
   {
      Event e = new Event(start, end, title);
      events.add(e);
   }
   
   public void goToEvent()
   {
      
   }
   
   public void listEvents()
   {
      SimpleDateFormat sdf = new SimpleDateFormat();
      
      for (Event event : events)
      {
         sdf.applyPattern("M E yyyy");
         String date = sdf.format(event.getDate());

         sdf.applyPattern("HH:mm");
         String start = sdf.format(event.getStartTime());
         String end = sdf.format(event.getEndTime());
         
         System.out.printf("%s %s - %s %s\n", date, start, end, event.getTitle());
      }
      System.out.printf("\n");
   }
   
   public void deleteEvent()
   {
      
   }

   public void saveEvents()
   {
      // Write events to events.txt
   }
   
   /**
    * Prints the calendar month but does not yet take into account EVENTS!!!
    */
   private void printCalendarByMonth()
   {
      // Set the calendar to the first day of the month we can get the first day of the month.
      calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
      
      // Store the last day of the current month.
      int lastDate = calendar.getActualMaximum(Calendar.DATE);
            
      // Store month/year
      // Locale.getDefault() returns the locale for the Java environment,
      // not the system environment. Ideally we would want the system locale.
      String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
      int year = calendar.get(Calendar.YEAR);
      
      // Print calendar header.
      System.out.printf(" %s %s\n", month, year);
      System.out.printf("%s\n", "Su Mo Tu We Th Fr Sa");
      
      // Sunday(1) - Saturday(7)
      int weekdayIndex;
      // First weekday of the month
      int firstWeekday = calendar.get(Calendar.DAY_OF_WEEK);
      
      // Buffer first weekday of the month
      for (weekdayIndex = 1; weekdayIndex < firstWeekday; ++weekdayIndex)
      {
         System.out.print("   ");
      }
      
      // Set counter for row wrapping.
      weekdayIndex = firstWeekday;
      for (int i = 1; i <= lastDate; ++i, ++weekdayIndex)
      {
         // May be able to wrap dates here for event days.
         
         if (weekdayIndex % 7 == 0)
         {
            System.out.printf("%2d\n", i);
         }
         else {
            System.out.printf("%2d ", i);
         }
      }
      System.out.printf("\n");
   }
   
   private void printCalendarByDay()
   {
      // This should be starting on today's date.
      
      // Set calendar to today's date.
      String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
      
      int day = calendar.get(Calendar.DAY_OF_WEEK);
      String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
      int date = calendar.get(Calendar.DAY_OF_MONTH);
      int year = calendar.get(Calendar.YEAR);

      // Print Day, Month, Year format
      System.out.printf("%s, %s %d, %d\n\n", daysOfTheWeek[day-1], month, date, year);
      // Print all events.
   }
   
   public void printCalendar()
   {
      if (view == View.MONTH)
      {
         this.printCalendarByMonth();
      }
      else 
      {
         this.printCalendarByDay();
      }
   }
   
   public void next()
   {
      if (view == View.MONTH)
      {
         this.nextMonth();
      }
      else
      {
         this.nextDay();
      }
   }
   
   public void previous()
   {
      if (view == View.MONTH)
      {
         this.previousMonth();
      }
      else
      {
         this.previousDay();
      }
   }
   
   /**
    * 
    */
   public void setMonthView()
   {
      view = View.MONTH;
   }
   
   /**
    * 
    */
   public void setDayView()
   {
      view = View.DAY;
   }
   
   /**
    * 
    */
   public void nextMonth() {
      calendar.add(Calendar.MONTH, 1);
   }
   
   /**
    * 
    */
   public void previousMonth() {
      calendar.add(Calendar.MONTH, -1);
   }
   
   /**
    * 
    */
   public void nextDay()
   {
      calendar.add(Calendar.DATE, 1);
   }
   
   /**
    * 
    */
   public void previousDay()
   {
      calendar.add(Calendar.DATE, -1);
   }
}
