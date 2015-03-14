/**
 * Created by scot on 3/11/15.
 */
public class Tester
{
    public static void main(String[] args)
    {
        System.out.println("Actual: " + Recursion.factorialIterative(5));
        System.out.println("Expected: 120");
        System.out.println("Actual: " + Recursion.factorialIterative(7));
        System.out.println("Expected: 5040");

        System.out.println("Actual: " + Recursion.factorialRecursive(4));
        System.out.println("Expected: 24");
        System.out.println("Actual: " + Recursion.factorialRecursive(6));
        System.out.println("Expected: 720");

        System.out.println("Actual: " + Recursion.powerRecursive(4, 2));
        System.out.println("Expected: 16");
        System.out.println("Actual: " + Recursion.powerRecursive(5, 3));
        System.out.println("Expected: 125");

        System.out.println("Actual: " + Recursion.reverseStringRecursive("abcde"));
        System.out.println("Expected: edcba");
        System.out.println("Actual: " + Recursion.reverseStringRecursive("amanaplanacanalpanama"));
        System.out.println("Expected: amanaplanacanalpanama");
        System.out.println("Actual: " + Recursion.reverseStringRecursive("bleep bloop"));
        System.out.println("Expected: poolb peelb");

        System.out.println("Actual: " + Recursion.getAllFactorsRecursive(12, 12));
        System.out.println("Expected: [1, 2, 3, 4, 6, 12]");
        System.out.println("Actual: " + Recursion.getAllFactorsRecursive(23, 23));
        System.out.println("Expected: [1, 23]");
        System.out.println("Actual: " + Recursion.getAllFactorsRecursive(76, 76));
        System.out.println("Expected: [1, 2, 4, 19, 38, 76]");
    }
}