/**
 * Author: Scot Matson (009602502)
 *   Date: 1/28/15
 *
 * This class should calculate the tax on an item
 * sold to somewhere on Yoshi's Island. On Yoshi's
 * Island, the tax rate is 7% (0.07) plus a flat
 * rate of one dollar (1.00) for every item that
 * costs one hundred dollars (100.0) or more.
 *
 * You MUST extend TaxCalculator to get credit. You
 * must use the taxRate variable in the superclass
 * and call the super class constructor.
 *
 * You must also override the toString method to
 * return
 * YoshiIslandTaxCalculator[taxRate=0.07]
 *
 * This class must have a constructor with no arguments.
 */
public class YoshiIslandTaxCalculator extends TaxCalculator
{
    /**
     *  Default constructor sets the TaxRate to 7%
     */
    YoshiIslandTaxCalculator () {
        super(0.07);
    }

    /**
     * calculateTax. Calculates the tax rate with a dollar surcharge if
     * at least $100 has been spent. Otherwise no charge is applied in
     * addition to the tax.
     *
     * @param originalAmount the cost to tax
     * @return the tax on that amount
     */
    public double calculateTax(double originalAmount)
    {
        if (originalAmount >= 100.00)
        {
            return originalAmount * super.getTaxRate() + 1.00;
        }

        return super.calculateTax(originalAmount);
    }

    public String toString() {
        return "YoshiIslandTaxCalculator[taxRate=" + super.getTaxRate() + "]";
    }
}
