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
        outcomes = new ArrayList<>();
        calculateAllOutcomes();
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
        outcomes = new ArrayList<>();
        for (int i = 0; i < symbols.length; ++i) {
            String startingSymbol = symbols[i];
            calculateAllOutcomes(wheels - 1, startingSymbol);
        }
    }

    private void calculateAllOutcomes(int currentWheel, String outcomeString) {
        // Base case.
        if (currentWheel < 1) {
            // At this juncture we should have a complete set,
            //   add it to the ArrayList and return.
            outcomes.add(outcomeString);

        } else {
            // Iterating through each symbol and recursively building our string.
            for (int i = 0; i < symbols.length; ++i) {
                String stringBuilder = outcomeString + " " + symbols[i];
                calculateAllOutcomes(currentWheel - 1, stringBuilder);
            }
        }
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
        outcomes = new ArrayList<>();
        for (int i = 0; i < symbols.length; ++i) {
            String startingSymbol = symbols[i];
            calculateOutcomesWithoutRepeats(wheels - 1, startingSymbol, startingSymbol);
        }
    }

    private void calculateOutcomesWithoutRepeats(int currentWheel, String outcomeString, String previousSym) {
        // Base case.
        if (currentWheel < 1) {
            // At this juncture we should have a complete set,
            //   add it to the ArrayList and return.
            outcomes.add(outcomeString);

        } else {
            // Iterating through each symbol and recursively building our string.
            for (int i = 0; i < symbols.length; ++i) {
                // We need check the current symbol against the previous symbol to prevent
                //   repetition.
                if (symbols[i].equals(previousSym)) { continue; }
                String stringBuilder = outcomeString + " " + symbols[i];
                calculateOutcomesWithoutRepeats(currentWheel - 1, stringBuilder, symbols[i]);
            }
        }
    }
}
