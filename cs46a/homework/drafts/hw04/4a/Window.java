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
    * gets the cost of the glaze used on this window
    * @return the cost of the glaze
    */
   double getCostOfGlaze() {
       return 0;
   }
   
   /**
    * Gets the cost of the glass used in this window
    * @return the cost of the glass
    */
   double getCostOfGlass() {
       return 0;
   }
   
   /**
    * the base cost + the cost of the glaze + the cost of the glass
    * @return the total window cost
    */
   double getTotalCost() {
       return 0;
   }
}
