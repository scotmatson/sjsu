/**
 * Author: Scot Matson (009602502)
 * Course: CS 46B
 * Section: 01
 * Homework 01
 *
 * This class should calculate the tax on an item
 * sold to somewhere in Wario Land. In Wario Land,
 * the tax rate is 1% (0.01) plus a flat
 * rate of ten dollars (10.00) on every item plus
 * 5% (0.05) times the original amount on any item 
 * with a "5" in the amount.
 *
 * You MUST extend TaxCalculator to get credit. You
 * must use the taxRate variable in the superclass
 * and call the super class constructor.
 *
 * You must also override the toString method to
 * return
 * WarioLandTaxCalculator[taxRate=0.01]
 *
 * This class must have a constructor with no arguments.
 */
public class WarioLandTaxCalculator extends TaxCalculator
{
    public WarioLandTaxCalculator () {
        super(0.01);
    }

    /**
     * Adjusts the tax rate based upon the presence of fives
     * and adds a flat rate surcharge.
     *
     * @param originalAmount the cost to tax
     * @return the modified tax rate
     */
    @Override
    public double calculateTax(double originalAmount) {
        if (hasFive(originalAmount)) {
            double rateModifier = (originalAmount * 0.05) + 10.00;
            return super.calculateTax(originalAmount) + rateModifier;
        }
        else {
            return super.calculateTax(originalAmount) + 10.00;
        }
    }

    /**
     * Formatted String of the tax rate
     *
     * @return formatted tax rate string
     */
    @Override
    public String toString() {
        return "WarioLandTaxCalculator[taxRate=" + getTaxRate() + "]";
    }

    /**
     * Evaluates a numerical value for the presence of
     * the number... 5!
     *
     * @param num
     * @return true if the given number contains a 5
     */
    public boolean hasFive(double num) {
        while (num > 0) {
           double currNum = num % 10;

           if (currNum == 5) {
               return true;
           }
           else {
               num /= 10;
           }
        }
        return false;
    }
}
