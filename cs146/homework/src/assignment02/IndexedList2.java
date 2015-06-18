package assignment02;

import java.util.*;

/**
 Created by scot on 6/17/15.
 */
public class IndexedList2<Integer> implements List<Integer>
{
   private List<Integer> ll;
   private List<Integer> al;
   private int accessInterval;
   private int listSize;

   public IndexedList2()
   {
      clear();
   }

   @Override
   public int size()
   {
      return listSize;
   }

   @Override
   public boolean isEmpty()
   {
      return (listSize == 0);
   }

   @Override
   public boolean contains(Object o) { return false; }
   @Override
   public Iterator<Integer> iterator() { return null; }

   @Override
   public Object[] toArray() { return new Object[0]; }
   @Override
   public <T> T[] toArray(T[] a) { return null; }

   @Override
   public boolean add(Integer integer)
   {
      boolean valueAdded = ll.add(integer);
      assignAccessInterval();
      ++listSize;
      return valueAdded;
   }

   @Override
   public boolean remove(Object o)
   {
      return ll.remove(o);
   }

   @Override
   public void clear()
   {
      ll = new LinkedList<>();
      al = new ArrayList<>();
      accessInterval = 10;
      listSize = 0;
   }

   @Override
   public Integer get(int index)
   {
      return ll.get(index);
   }

   @Override
   public Integer set(int index, Integer element)
   {
      return ll.set(index, element);
   }

   @Override
   public void add(int index, Integer element)
   {
      ll.add(index, element);
   }


   @Override
   public Integer remove(int index)
   {
      return ll.remove(index);
   }

   public void setAccessInterval(int k)
   {
      accessInterval = k;
   }
   public int getAccessInterval()
   {
      return accessInterval;
   }
   public void assignAccessInterval()
   {
      if (listSize % accessInterval == 0)
      {
         // This is storing a value... we need to store a position.
         al.add(ll.get(listSize));
      }
   }

   @Override
   public boolean containsAll(Collection<?> c) { return false; }
   @Override
   public boolean addAll(Collection<? extends Integer> c) { return false; }
   @Override
   public boolean addAll(int index, Collection<? extends Integer> c) { return false; }
   @Override
   public boolean removeAll(Collection<?> c) { return false; }
   @Override
   public boolean retainAll(Collection<?> c) { return false; }
   @Override
   public int indexOf(Object o) { return 0; }
   @Override
   public int lastIndexOf(Object o) { return 0; }
   @Override
   public ListIterator<Integer> listIterator() { return null; }
   @Override
   public ListIterator<Integer> listIterator(int index) { return null; }
   @Override
   public List<Integer> subList(int fromIndex, int toIndex) { return null; }

   // For Debugging
   public void getArrayList()
   {
      for (int i = 0; i < al.size(); ++i)
      {
         System.out.println("["+i+"]" + " " + al.get(i));
      }
   }
}
