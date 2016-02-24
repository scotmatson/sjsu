/**
 * Author: Scot Matson (009602502)
 * Course: CS 46B
 * Section: 01
 * Homework 01
 *
 * This class should calculate the tax on an item
 * sold to somewhere in Mario World. In Mario World, 
 * the tax rate is 4% (0.04) for any item weighing
 * under 100 pounds, and 8% on any item weighing
 * 100 pounds or more.
 *
 * You MUST extend TaxCalculator to get credit. You
 * must use the taxRate variable in the superclass
 * and call the super class constructor.
 *
 * You must also override the toString method to
 * return
 * MarioWorldTaxCalculator[taxRate=TAX_RATE]
 * Where TAX_RATE should be either 0.04 or 0.08 based
 * on the weight of the item being taxed.
 *
 * This class must have a constructor with one arguments,
 * which is a double that represents the weight in pounds 
 * of the object to be taxed.
 */
public class MarioWorldTaxCalculator extends TaxCalculator
{
    private final int WEIGHT_LIMIT = 100;
    private double pounds;

    /**
     * Constructor which takes weight into account
     *
     * @param pounds
     */
    MarioWorldTaxCalculator (double pounds) {
        super(0.04);
        this.pounds = pounds;
    }

    /**
     *  Constructor for when is unknown
     */
    MarioWorldTaxCalculator () {
        super(0.04);
    }

    /**
     * Calculates a weight based tax
     *
     * @param originalAmount the cost to tax
     * @return the tax
     */
    @Override
    public double calculateTax(double originalAmount) {
        if (pounds < WEIGHT_LIMIT) {
            return super.calculateTax(originalAmount);
        }
        else {
            super.setTaxRate(0.08);
            return super.calculateTax(originalAmount);
        }
    }

    /**
     * Formats the tax rate and prints it out
     *
     * @return string formatted tax rate
     */
    @Override
    public String toString() {
        return "MarioWorldTaxCalculator[taxRate=" + getTaxRate() + "]";
    }
}
