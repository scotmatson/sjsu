/**
 * TaxCalculator.
 * This class encapsulates a tax calculation. If the
 * tax calculation is based purely on amount, then 
 * this class will work, but you will need to
 * extend this class using inheritance to calculate
 * more complex taxes.
 */
public class TaxCalculator
{
    private double taxRate;

    public TaxCalculator(double taxRate)
    {
        this.taxRate = taxRate;
    }

    public double getTaxRate(){ return this.taxRate; }
    public void setTaxRate(double newRate){ this.taxRate = newRate; }

    /**
     * calculateTax. Return the tax on the dollar amount
     * in originalAmount.
     *
     * @param originalAmount the cost to tax
     * @return the tax on that amount
     */
    public double calculateTax(double originalAmount)
    {
        return originalAmount * taxRate;
    }

    @Override
    public String toString()
    {
        return "TaxCalculator[taxRate=" + this.taxRate + "]";
    }
}