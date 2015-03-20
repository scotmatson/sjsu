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
     * call calculateAllOutcomes in the final. In the draft,
     * just set outcomes to a new ArrayList.
     *
     * @param newWheels the number of wheels displayed
     * @param newSymbols the symbols that appear on each wheel
     */
    public SlotMachine(int newWheels, String... newSymbols)
    {
        this.wheels = newWheels;
        this.symbols = newSymbols;
        outcomes = new ArrayList<>();
    }

    /**
     * printOutcomes. A convenience method for testing.
     * Print everything in the outcomes ArrayList to console
     * in numbered order.
     *
     * Ex:
     * 1: outcome1
     * 2: outcome2
     * 3: outcome3
     * ...
     */
    public void printOutcomes()
    {
        for (int i = 0; i < outcomes.size(); ++i) {
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

}
