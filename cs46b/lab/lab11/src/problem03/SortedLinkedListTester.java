package problem03;

import java.util.ListIterator;

public class SortedLinkedListTester {
    public static void main(String[] args)
    {
        SortedLinkedList s = new SortedLinkedList(new TestComparator());
        s.add(10);
        s.add(45);
        s.add(5);

        ListIterator li = s.listIterator();

        while(li.hasNext())
            System.out.print(li.next() + " ");
        System.out.println("");
        System.out.println("Expected: 45 10 5");
    }
}