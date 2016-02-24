/**
 * Created by scot on 1/31/15.
 */
public class UtilTester
{
    public static void main(String[] args) {
        //Integer[] values00 = {2, 5, 4, 1, 7, 10};
        //System.out.println(Util.smallestAfter(values00, 5));
        //System.out.println("Expected: 7");

        //Integer[] values01 = {2, 5, 1, 3, 2};
        //System.out.println(Util.smallestAfter(values01, 5));
        //System.out.println("Expected: null");

        //Integer[] values02 = {2, 6, 10, 5, 8, 9};
        //System.out.println(Util.smallestAfter(values02, 5));
        //System.out.println("Expected: 6");

        //Integer[] values = {2, 6, 5, 4, 1, 7};
        //Util.printSorted(values);
        //System.out.println("Expecting: 1, 2, 4, 5, 6, 7");

        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Util.printSorted(words);
        System.out.println("Expecting: Mary a had lamb little");
    }
}
