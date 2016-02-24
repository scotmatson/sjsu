
public class Building
{
   
    private double x;

    /**
     * Constructor for objects of class Building
     * @param x the height of the building
     */
    public Building(double theX)
    {
        // initialise instance variables
        x = theX;
    }
    
    //... other methods
    
    /**
     * Gets the volume of the building
     * surfac area = 16x^2 + 5??x^2
     * @return the volume of he bulding
     */
    public double surfaceArea()
    {
        //16x2 + 5?x2
        return 16 * Math.pow(x, 2) + 5 * Math.PI * (Math.pow(x, 2));

    }

  
}
