/**
 * Models a window with a triangle on top and a semi-circle
 * below
 */
public class Window
{
   public final static double INCHES_PER_FOOT = 12; //constant
   public final static double OUNCES_PER_POUND = 16; //constant
   public final static double SQ_IN_PER_FLUID_OUNCE_GLAZE = 20; //constant
   public final static double SQ_IN_PER_OUNCE_GLASS = 1; //constant
   public static final double GLAZE_COST_FLUID_OUNCE = 10.55;  //constant
   public static final double GLASS_COST_PER_POUND = 5.0;
   public final static double BASE_COST = 75.00; //constant
   
   private double base;
   private double height;
   
   /**
    * Constructs a Window with the given dimensions in feet
    * @param theBase of the window in feet
    * @param theHeight of the window in feet
    */
   public Window(double theBase, double theHeight)
   {
       base = theBase;
       height = theHeight;
   }
   
   /** 
    * Gets the base of the triangular shape of the window
    * @return the base of the triangular shape
    */
   public double getBase()
   {
       return base;
   }
   
   /** 
    * Gets the height of the triangular shape of the window
    * @return the height of the triangular shape
    */
   public double getHeight()
   {
       return height;
   }
   
   /**
    * Returns the area of a window given the base and height
    * @return the area of the window
    */
   public double windowAreaInches() {
	   double baseInches = base * INCHES_PER_FOOT;
	   double heightInches = height * INCHES_PER_FOOT;
	   
       double winTop = (baseInches * heightInches) * 0.5;
       double winBase = (Math.PI * Math.pow((baseInches * 0.5), 2)) * 0.5;
       
       return (winTop + winBase);
   }
   
   /**
    * gets the cost of the glaze used on this window
    * @return the cost of the glaze
    */
   double getCostOfGlaze() {
	   double costPerSqIn = GLAZE_COST_FLUID_OUNCE / SQ_IN_PER_FLUID_OUNCE_GLAZE;
       return (costPerSqIn * windowAreaInches());
   }
   
   /**
    * Gets the cost of the glass used in this window
    * @return the cost of the glass
    */
   double getCostOfGlass() {
       return ((windowAreaInches() / OUNCES_PER_POUND) * GLASS_COST_PER_POUND);
   }
   
   /**
    * the base cost + the cost of the glaze + the cost of the glass
    * @return the total window cost
    */
   double getTotalCost() {
       return (BASE_COST + getCostOfGlass() + getCostOfGlaze());
   }
}
