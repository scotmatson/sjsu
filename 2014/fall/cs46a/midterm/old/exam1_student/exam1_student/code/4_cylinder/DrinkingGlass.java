
public class DrinkingGlass
{
    private double height;

    /**
     * Constructor for objects of class Drinking
     * @param theHeight the height of the base
     */
    public DrinkingGlass(double theHeight)
    {
        height = theHeight;
    }

    /**
     * Sets the height of the base cylinder of this object
     * @param newHeight the new height of this DrinkingGlass
     */
    public void setHeight(double newHeight)
    {
        height = newHeight;
    }
    
    /**
     * Uses the formula PI * r^2 * height to find the volume of a cylinder
     * using the user set height
     * @return cylinderArea returns the calculated volume of a glass
     */
    public double getVolume() {
        //Top cylinder
        double areaTop = Math.PI * Math.pow((3.0/2.0) * height, 2) * (10 * height);
  
        //Bottom cylinder
        double areaBottom = Math.PI * Math.pow((3 * height), 2) * height;
        
        double cylinderArea = (areaTop + areaBottom);
        return cylinderArea;
    }
}
