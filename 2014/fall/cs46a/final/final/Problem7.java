//ID9602502
/*
 * The Problem7 class contains a bunch of miscellaneous static methods. 
 * Complete each method described below. These methods may be pretty silly, 
 * but they will give you the chance to earn some points with some simple 
 * coding.
 *
 * You will upload Problem7.java
 */
public class Problem7
{
    /**
     *  A static method that declares and creates an array that can hold
     *  25  doubles. 
     *  @return the array.
     */

    public static  double[] makeArray()
    {
        return  new double[25];
    }

    /**
     * a static method that takes a two-dimensional array of Strings of 
     * unknown size and assigns the String December to the 
     *  last column of the last row.
     * @param two-dimensional array of Strings
     */

    public static void addElement(String[][] words)
    {
        words[words.length][words[0].length] = "December";
    }

    /** 
    a static method that determines if a string is equal 
    to another string
    @param s1 the string to test. 
    @return true if the String is either  "Up" or "UP". 
    Otherwise false. Also returns false if the parameter is  null.
     */
    public static boolean isWord(String s1)
    {
        return (s1.compareTo("Up") == 0 || s1.compareTo("UP") == 0);
    }

    /**
     * Gets the number of characters in the two string parameters
     * @param s1 first string 
     * @param s2 second string
     * @return the number of characters in both strings combined. 
     * If one string has 3 characters and the other 4, you would return 7.
     */
    public static int getCharacterCount(String s1, String s2)
    {
        return s1.length() + s2.length();
    }

    /**
     * Assume you are given a class Finance with a static method 
     * 
     *    public static double calculateTip(double costOfDinner)  
     * 
     * which returns the amount of the tip that should be added to the 
     * cost of the dinner.
     * 
     * This method calculates the total payment for a dinner of a given cost,
     * that is, the cost of the dinner plus the amount of the tip
     * 
     * @param costOfDinner the cost of the meal itself
     * @return the total cost of the meal (the cost of the dinner + the tip). 
     * 
     * You must use the calculateTip method to get any credit.
     */

    public static double totalPayment(double costOfDinner)
    {
        return Finance.calculateTip(costOfDinner) + costOfDinner;
    }
}
