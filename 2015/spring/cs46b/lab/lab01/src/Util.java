import java.util.ArrayList;

public class Util
{
    /**
     Returns the smallest element in an array
     @param values an array of non-null Comparable values of length >= 1
     @return the smallest value in values
     */
    public static Comparable smallest(Comparable[] values)
    {
        Comparable smallestSoFar = values[0];
        for (int i = 1; i < values.length; i++)
            if (values[i].compareTo(smallestSoFar) < 0)
                smallestSoFar = values[i];
        return smallestSoFar;
    }

    /**
     Returns the smallest element in the array larger than a given value.
     @param values an array of non-null Comparable values
     @param after a value that may or may not be present in the array
     @return the smallest value in the array larger than value, or null if there isn't one
     */
    public static Comparable smallestAfter(Comparable[] values, Comparable after) {
        Comparable smallestInRange = largest(values);
        if (after.compareTo(smallestInRange) == 0) {
            return null;
        } else {
            for (int i = 0; i < values.length; ++i) {
                if (values[i].compareTo(after) > 0 && values[i].compareTo(smallestInRange) < 0) {
                    smallestInRange = values[i];
                }
            }
        }
        return smallestInRange;
    }

    /**
     * Returns the largest element in the Array.
     * Helper method for smallestAfter()
     * @param values an array of non-null Comparable values
     * @return the largest value in values
     */
    public static Comparable largest(Comparable[] values)
    {
        Comparable largestSoFar = values[0];
        for (int i = 1; i < values.length; ++i)
            if(values[i].compareTo(largestSoFar) > 0)
                largestSoFar = values[i];
        return largestSoFar;
    }

    public static void printSorted(Comparable[] values)
    {
        Comparable currIndex = smallest(values);
        System.out.println(currIndex);
        while (smallestAfter(values, currIndex) != null) {
            System.out.println(smallestAfter(values, currIndex));
            currIndex = smallestAfter(values, currIndex);
        }
    }
}