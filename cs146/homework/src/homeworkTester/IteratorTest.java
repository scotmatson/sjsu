package homeworkTester;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 Created by scot on 7/19/15.
 */
public class IteratorTest
{
   public static void main(String[] args)
   {
      LinkedList ll = new LinkedList<>();
      ll.add("apple");
      ll.add("banana");
      ll.add("chedder");
      ll.add("dragonfruit");

      List l = new LinkedList<>();
      l.add("austin powers");
      l.add("beauty and the beast");
      l.add("caddyshack");
      l.add("dr horrible's sing a-long blog");

      Iterator lli = ll.iterator();
      Iterator li = l.iterator();
      while (lli.hasNext())
      {
         System.out.println(lli.next());
      }
      while (li.hasNext())
      {
         System.out.println(li.next());
      }



   }
}
