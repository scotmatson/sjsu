import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Demonstrates O(n) runtime by removing
 *  an element from an ArrayList in comparison to a LinkedList
 *
 *  As the ArrayList increases in size so does the amount of time to
 *      run the program.
 *  As the LinkedList increases in size the time it takes to run the
 *      program remains constant.
 */
public class Remove1
{
    private static final int TESTS_TO_RUN = 4;

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int test = Integer.parseInt(args[1]);

        if (test == 1) { arrayListTester(n, 1); }
        if (test == 2) { linkedListTester(n, 1); }
    }

    public static void arrayListTester(int n, int testCase) {
        List<Integer> lst = new ArrayList<Integer>(n);

        for (int i = 1; i <= n; i++) { lst.add(i); }
        for (int i = 1; i < n; i++) { lst.remove(0); }

        System.out.println("Last element remaining in ArrayList: " + lst.get(0));
        if (testCase < TESTS_TO_RUN) { arrayListTester(n*2, testCase+1); }
    }

    public static void linkedListTester(int n, int testCase) {
        List<Integer> lst = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) { lst.add(i); }
        for (int i = 1; i < n; i++) { lst.remove(0); }

        System.out.println("Last element remaining in LinkedList: " + lst.get(0));
        if (testCase < TESTS_TO_RUN) { linkedListTester(n*2, testCase+1); }
    }
}