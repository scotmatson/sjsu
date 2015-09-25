/**
 * 
 */
import java.util.GregorianCalendar;
import java.util.Scanner;

enum State {
   ACTIVE,
   INACTIVE,
   EXIT,
   ERR
}
public class MyCalendar
{ 
   State status = State.ACTIVE;
   Scanner in = new Scanner(System.in);
   
   public void printHeader()
   {
      System.out.printf("%s\n", "###################################");
      System.out.printf("%s %33s\n", "#", "#");
      System.out.printf("%s %27s %5s\n", "#", "Scot Matson presents,", "#");
      System.out.printf("%s %17s %15s\n", "#", "My Calendar", "#");
      System.out.printf("%s %33s\n", "#", "#");
      System.out.printf("%s %26s %6s\n", "#", "A Java console based", "#");
      System.out.printf("%s %23s %9s\n", "#", "digital scheduler","#");
      System.out.printf("%s %33s\n", "#", "#");
      System.out.printf("%s\n\n", "###################################");
   }
   
   /*
    * Displays main menu options
    * and prompts user to make a selection.
    * 
    * @return selection result.
    */
   public char printMenu()
   {
      System.out.printf("%s\n", "Please make a selection from the following list of options.");
      System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n", 
            "[L]oad",
            "[V]iew by",
            "[C]reate",
            "[G]o to",
            "[E]vent list",
            "[D]elete",
            "[Q]uit");
      
      return parseInput();
   }
   
   public void processEvent(char c, Planner p)
   {
      switch (Character.toLowerCase(c))
      {
         case 'l':
            p.loadEvents();
            break;
         case 'v':
            p.toggleView();
            break;
         case 'c':
            //p.createEvent(date, title, description);
            break;
         case 'g':
            p.goToEvent();
            break;
         case 'e':
            p.listEvents();
            break;
         case 'd':
            p.deleteEvent();
            break;
         case 'q':
            status = AppState.EXIT;
            break;
         default:
            break;
      }
   }
   
   /**
    * Parses console input and returns the first
    * character.
    * 
    * @return user input.
    */
   public char parseInput()
   {
      char ch;
      // Receive input.
      System.out.printf(">> ");
      ch = in.findInLine(".").charAt(0);
      
      // Flush any additional input.
      in.nextLine();
      
      // Display user selection.
      System.out.printf("%c\n\n", ch);
      
      return ch;
   }
   
   /**
    *    
    */
   public void run()
   {     
      GregorianCalendar gc = new GregorianCalendar();
      Planner p = new Planner("events.txt", gc);
      char action;
      
      while (status != AppState.EXIT) {   
         
         // Display Calendar
         action = printMenu();
         processEvent(action, p);
      }
      
      exit();
   }
   
   /*
    * Exits the application.
    */
   public void exit()
   {
      in.close();
      System.exit(0);
   }
   
   /**
    * 
    * @param args
    */
   public static void main(String[] args)
   {
      MyCalendar mc = new MyCalendar();
      mc.printHeader();
      mc.run();
   }
}
