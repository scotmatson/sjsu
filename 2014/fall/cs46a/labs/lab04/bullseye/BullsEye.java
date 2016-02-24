public class BullsEye
{
    private int x;
    private int y;
    private double d;
    Ellipse ring;

    /**
     * Constructs a bulls eye with a given center.
     * @param centerX the x coordinate of the center
     * @param centerY the y coordinate of the center
     */
    public BullsEye(int centerX, int centerY)
    {
        this.x = centerX;
        this.y = centerY;
        this.d = 90;
    }

    /**
     * Draws the bulls eye
     */
    public void draw()
    {  
        ring = new Ellipse(x - d / 2, y - d / 2, d, d);
        ring.setColor(Color.BLUE);
        ring.fill();
        
        ring = new Ellipse(x - d / 3, y - d / 3, (2*d)/3, (2*d)/3);
        ring.setColor(Color.WHITE);
        ring.fill();
        
        ring = new Ellipse(x - d / 6, y - d / 6, d/3, d/3);
        ring.setColor(Color.RED);
        ring.fill();
    }

    public void grow(int diam) {
        d += diam;
    }
} 