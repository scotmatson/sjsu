
/**
 * Paints a colorful flower to the canvas at
 * a specified location.
 * 
 * @author (Scot Matson)
 * @version (20140911)
 */
public class Flower {

    private final int BUD_WIDTH  = 30;
    private final int BUD_HEIGHT = 30;
    private final int PEDAL_WIDTH = 30;
    private final int PEDAL_HEIGHT= 30;

    private int x;
    private int y;

    /**
     * Constructor setting the default location of the flower
     * given no arguments.
     */
    public Flower() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor, given an x and y coordinate sets the default
     * location of the flower.
     * @param x the origin on the x-axis
     * @param y the origin on the y-axis
     */
    public Flower(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws a flower to the canvas using the x and y values
     * as its starting location in the upper left corner.
     */
    public void draw() {
        // Initialize objects which make up the parts of a flower
        Ellipse flwrBud = new Ellipse((x + 30), (y + 30), BUD_WIDTH, BUD_HEIGHT);
        Ellipse pedalTop = new Ellipse((x + 30), (y), PEDAL_WIDTH, PEDAL_HEIGHT);
        Ellipse pedalRight = new Ellipse((x + 60), (y + 30), PEDAL_WIDTH, PEDAL_HEIGHT);
        Ellipse pedalBottom = new Ellipse((x + 30), (y + 60), PEDAL_WIDTH, PEDAL_HEIGHT);
        Ellipse pedalLeft = new Ellipse((x), (y + 30), PEDAL_WIDTH, PEDAL_HEIGHT);

        // Create custom color for flower pedals
        Color magenta = new Color(200, 0, 200);

        // Set colors to objects
        flwrBud.setColor(Color.YELLOW);
        pedalTop.setColor(magenta);
        pedalRight.setColor(magenta);
        pedalBottom.setColor(magenta);
        pedalLeft.setColor(magenta);

        // Paint the objects to the canvas
        flwrBud.fill();
        pedalTop.fill();
        pedalRight.fill();
        pedalBottom.fill();
        pedalLeft.fill();
    }
}