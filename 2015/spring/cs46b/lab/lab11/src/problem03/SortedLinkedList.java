package problem03;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class SortedLinkedList
{
    private List list = new LinkedList();
    private Comparator comp;

    public SortedLinkedList(Comparator cmp)
    {
        comp = cmp;
    }

    /**
     Adds an element in the place it should go, using the comparator.
     This is the method you need to write.  No other given code is incorrect.
     */
    public void add(Object element)
    {
        if (list.size() == 0) { list.add(0, element); }
        else {
            for (int i = 0; i < list.size(); ++i) {
                if ((comp.compare(list.get(i), element) > 0) || (comp.compare(list.get(i), element) == 0))
                {
                    list.add(i, element); return;
                }
            }
            list.add(element);
        }
    }

    public Object get(int i)
    {
        return list.get(i);
    }

    public ListIterator listIterator()
    {
        return new SortedListIterator();
    }

    class SortedListIterator implements ListIterator
    {
        ListIterator li;
        public SortedListIterator()
        {
            li = list.listIterator();
        }

        public boolean hasNext()
        {
            return li.hasNext();
        }

        public boolean hasPrevious()
        {
            return li.hasPrevious();
        }

        public Object next()
        {
            return li.next();
        }

        public Object previous()
        {
            return li.previous();
        }

        public int nextIndex()
        {
            return li.nextIndex();
        }

        public int previousIndex() {
            return li.previousIndex();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void set(Object e) {
            throw new UnsupportedOperationException("Not supported ever.");
        }

        @Override
        public void add(Object e) {
            throw new UnsupportedOperationException("Not supported ever.");
        }
    }
}