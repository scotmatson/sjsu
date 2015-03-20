/**
 * Created by scot on 3/13/15.
 */
import java.util.ArrayList;

public class SlotMachine
{
    private String[] symbols;
    private int wheels;
    public ArrayList<String> outcomes;

    /**
     * SlotMachine constructor. Set wheels and symbols, then
     * call calculateAllOutcomes.
     *
     * @param newWheels the number of wheels displayed
     * @param newSymbols the symbols that appear on each wheel
     */
    public SlotMachine(int newWheels, String... newSymbols)
    {
        this.wheels = newWheels;
        this.symbols = newSymbols;
    }

    /**
     * printOutcomes. A convenience method for testing.
     * Print everything in the outcomes ArrayList to console.
     */
    public void printOutcomes()
    {
        for(int i = 0; i < outcomes.size(); ++i) {
            System.out.println(i+1 + ": " + outcomes.get(i));
        }
    }

    /**
     * getNumberOfOutcomes. Calculate the total number of
     * possible outcomes given the number of symbols, number
     * of wheels, and that symbols may be repeated.
     *
     * @return an integer representing the total number of possible outcomes
     */
    public int getNumberOfOutcomes()
    {
        return (int) Math.pow(symbols.length, wheels);
    }

    /**
     * calculateAllOutcomes. Calculate all possible space-separated outcomes
     * on this slot machine and store them in the outcomes ArrayList.
     * Symbols can be repeated.
     *
     * If the symbols are "lemon", "apple", and "cherry", then possible
     * outcomes include "lemon apple cherry", "lemon lemon lemon",
     * "apple cherry lemon" and many more.
     *
     * You MUST use recursion to complete this method for full credit.
     *
     * You MUST use a recursive helper method to complete this method for full credit.
     *
     */
    public void calculateAllOutcomes()
    {
        calculateAllOutcomes(wheels, symbols.length-1, getNumberOfOutcomes());
    }

    private void calculateAllOutcomes(int numWheels, int numSymbols, int outcomesLeft) {

        // Base case


        // Work
        // Add to the ArrayList

        // Recursion



    }

    /**
     * calculateOutcomesWithoutRepeats. Calculate all possible
     * space-separated outcomes that DO NOT INCLUDE REPEATED SYMBOLS
     * and store them in the outcomes ArrayList.
     * Symbols can be repeated.
     *
     * If the symbols are "lemon", "apple", and "cherry", then possible
     * outcomes include "lemon apple cherry", "apple cherry lemon",
     * "cherry apple lemon" and more.
     *
     * You MUST use recursion to complete this method for full credit.
     *
     * You MUST use a recursive helper method to complete this method for full credit.
     *
     */
    public void calculateOutcomesWithoutRepeats()
    {
        // YOUR CODE HERE
    }
}
