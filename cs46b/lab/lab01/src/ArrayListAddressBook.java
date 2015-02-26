import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** An implementation of the AddressBook interface that uses
 *   an array list to store the data.
 */
public class ArrayListAddressBook implements AddressBook {
   private ArrayList<Item> items = new ArrayList<Item>();
   private String source;
   private boolean modified;

   public void load(String sourceName)
   {
      source = sourceName;
      try
      {
         Scanner in = new Scanner(new File(source));
         items = new ArrayList<Item>();
         while (in.hasNextLine())
            items.add(new Item(in.nextLine(), in.nextLine(), in.nextLine()));
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
         source = null;
         items = new ArrayList<Item>();
      }
   }

   public String get(String name, String key)
   {
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
            return it.getValue();
      }
      return null;
   }


   public String put(String name, String key, String value)
   {
      modified = true;
      for (Item it : items)
      {
         if (name.equals(it.getName()) && key.equals(it.getKey()))
         {
            String oldValue = it.getValue();
            it.setValue(value);
            return oldValue;
         }
      }
      items.add(new Item(name, key, value));
      return null;
   }

   public void save() 
   {
      if (!modified) return;
      try 
      {
         PrintWriter out = new PrintWriter(source);
         for (Item it : items)
         {
            out.println(it.getName());
            out.println(it.getKey());
            out.println(it.getValue());
         }
         out.close();
         modified = false;
      }
      catch (Exception ex) 
      {
        ex.printStackTrace();
      }
   }

    @Override
    public String remove(String name, String key) {
        return null;
    }

    public Item getFirst() {
        return Collections.min(items);
    }

    /**
     * Iterate through a list of items and if found return true.
     *
     * @param anItem
     * @return True if the item exists
     */
    public boolean contains (Item anItem) {
        for (Item it : items) {
            if(it.equals(anItem))  return true;
        }
        return false;
    }

    @Override
    public Item getNext(Item previous) {
        Item[] itemArray = new Item[items.size()];
        items.toArray(itemArray);
        Comparable result = Util.smallestAfter(itemArray, previous);
        return (Item) result;
    }
}
