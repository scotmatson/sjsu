/**
 * Created by scot on 3/11/15.
 */
import java.util.ArrayList;

public class Recursion
{
    /**
     * factorialIterative.
     *
     * Calculate the factorial of a number
     * using iteration. Write this method first,
     * to get an idea of how the following methods
     * should work.
     *
     * Recall: Factorial(5) = 5 * 4 * 3 * 2 * 1;
     *
     * @param n the argument for which to calculate the factorial
     * @return the result of the calculation
     */
    public static int factorialIterative(int n)
    {
        int fact = 1;
        while (n > 0) {
            fact *= n;
            --n;
        }
        return fact;
    }

    /**
     * factorialRecursive.
     *
     * Calculate the factorial of a number
     * using recursion.
     *
     * Recall: Factorial(4) = 4 * 3 * 2 * 1;
     *
     * You will get zero points for this method if
     * you do not use recursion.
     *
     * @param n the argument for which to calculate the factorial
     * @return the result of the calculation
     */
    public static int factorialRecursive(int n)
    {
        if (n == 0) return 1; // Base case.
        return n * factorialRecursive(n-1);
    }

    /**
     * powerRecursive.
     *
     * Raise base to the power of exponent.
     *
     * Recall: power(5, 3) = 5 * 5 * 5
     * Recall: power(4, 2) = 4 * 4
     *
     * Don't forget to write the base case.
     *
     * If you do not use recursion, you will
     * get zero points for this method.
     *
     * @param base the base to multiply
     * @param exponent the number of times to multiply it by itself
     * @return the result of the calculation
     */
    public static int powerRecursive(int base, int exponent)
    {
        if (exponent == 0) return 1; // Base case.
        --exponent;
        return base * powerRecursive(base, exponent);
    }

    /**
     * reverseStringRecursive.
     *
     * Use recursion to reverse a String.
     *
     * reverseStringRecursive("qwerty") = "ytrewq"
     *
     * Don't forget the base case.
     *
     * If you do not use recursion to solve this
     * problem, you will get zero points.
     *
     * @param input the String to reverse
     * @return the reversed String
     */
    public static String reverseStringRecursive(String input)
    {
        int strLen = input.length();
        strLen--;
        if (strLen == 0) return input.substring(0, 1); // Base case.
        return input.substring(strLen, strLen+1) + reverseStringRecursive(input.substring(0, strLen));
    }

    /**
     * getAllFactorsRecursive.
     *
     * Calculate all POSITIVE INTEGER factors
     * for a given number. Factors are numbers
     * that evenly divide another number.
     *
     * So the factors of 6 are 1, 2, 3, and 6. The
     * factors of 14 are 1, 2, 7, and 14.
     *
     * You must use recursion to get any points.
     *
     * Don't forget to write the base case.
     *
     * HINT: Create a temporary ArrayList to
     * store the results of your recursive call.
     * Then add the contents of that ArrayList
     * to the ArrayList you will return.
     *
     * @param base the number for which you want to calculate all factors
     * @param currentFactor the current factor to test
     * @return an ArrayList containing all positive factors of base
     */
    public static ArrayList<Integer> getAllFactorsRecursive(int base, int currentFactor)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        ArrayList<Integer> temp;

        if (currentFactor > 0) {
            if (base % currentFactor == 0) factors.add(base / currentFactor);
            temp = new ArrayList<>(getAllFactorsRecursive(base, --currentFactor));
            factors.addAll(temp);
        }

        return factors;
    }
}


// WORKS IN REVERSE ORDER
//    public static ArrayList<Integer> getAllFactorsRecursive(int base, int currentFactor)
//    {
//        ArrayList<Integer> factors = new ArrayList<>();
//        ArrayList<Integer> temp = new ArrayList<>();
//
//        if (currentFactor > 0) {
//            if (base % currentFactor == 0) factors.add(currentFactor);
//
//            temp = getAllFactorsRecursive(base, --currentFactor);
//        }
//
//        factors.addAll(temp);
//
//        return factors;
//    }