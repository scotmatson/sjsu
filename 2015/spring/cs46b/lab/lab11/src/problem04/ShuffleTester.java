package problem04;

public class ShuffleTester
{
    public static void main(String[] args)
    {
        LinkedList l = new LinkedList();
        for(int i = 1; i <= 10; i++)
        {
            l.addFirst("" + i);
        }  //After this, the list contains 10 9 8 7 6 5 4 3 2 1

        l.perfectShuffle();
        ListIterator li = l.listIterator();
        while(li.hasNext())
        {
            System.out.print(li.next() + " ");
        }
        System.out.println("");
        System.out.println("Expected:  10 5 9 4 8 3 7 2 6 1");
    }
}