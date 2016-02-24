/**
 * Author: Scot Matson
 * Date: 09/30/14
 * Type: Draft
 * Assn: 5b
 * Course: cs49c - 01
 * Description: TrafficLight models a traffic signal that can change colors 
 * as a real signal does.
 */
public class TrafficLight
{   
    public static final int NUMLIGHTS = 3;
    public static final int DIAMETER = 30;
    public static final int RED = 0;
    public static final int YELLOW = 1;
    public static final int GREEN = 2;
    public static final int GREY = 3;
    private int currentLight;
    private int x;
    private int y;

    /**
     * Constructor for objects of class TrafficLight
     */
    public TrafficLight(int theX, int theY)
    {
        this.x = theX;
        this.y = theY;
        this.currentLight = RED;
    }
    
    /**
     * Creates the drawing of the traffic light
     */
    public void draw() {
       //Building out the light housing
       Rectangle frame = new Rectangle(x, y, DIAMETER, DIAMETER*NUMLIGHTS);       
       frame.setColor(Color.BLACK);
       frame.fill();
       
       //Lighting and positioning the lights.
       for(int i = 0; i < NUMLIGHTS; ++i) {
           //Creating our the shell for a light
           Ellipse light = new Ellipse(x, y + (DIAMETER * i), DIAMETER, DIAMETER);
           
           //Setting the default state to off [GRAY]
           light.setColor(Color.GRAY);
           
           //Setting the active state for the currentLight
           if (currentLight == i) {
               switch(currentLight) {
                   case RED: light.setColor(Color.RED); break;
                   case YELLOW: light.setColor(Color.YELLOW); break;
                   case GREEN: light.setColor(Color.GREEN); break;
                }
           }
           light.fill();
       }
    }
    
    /**
     * Retrieves the state of the current light
     * @return light color holding active state
     */
    public String getLight() {
        String light = null;
        switch(currentLight) {
            case RED: light =  "red"; break;
            case YELLOW: light =  "yellow"; break;
            case GREEN: light =  "green"; break;
        }
        return light;
    }
    
    /**
     * Modifies the state of the light
     */
    public void changeLight() {
        currentLight = (++currentLight % 3);
        return;
    }
}
