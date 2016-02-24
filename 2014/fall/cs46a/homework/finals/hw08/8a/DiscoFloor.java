/**
 * Scot Matson
 * CS46A
 * Section 01
 * Assn 8a
 * 2014-10-23
 */
import java.util.Random;

public class DiscoFloor
{
    public static final int RED = 0; 
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static final int YELLOW = 3;
    public static final int MAGENTA = 4;
    public static final int CYAN = 5;
    private static final int SEED = 4000;
    private static final int NUM_TILES_PER_SIDE = 8;
    private int x;
    private int y;
    private int width;
    private Random generator;
    
    /**
     * Creates a DiscoFloor 
     * @param x the x coordinate of the upper left-hand 
     * corner of the floor
     * @param y the y coordinate of the upper left-hand 
     * corner of the floor
     * @param width the width and height of each tile
     */
    public DiscoFloor(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        
        generator = new Random(SEED);
    }
    
    /**
     * Draws this disco floor.
     */ 
    public void draw() {
        int xPos, row, col; 
        int yPos = y;
        for(row = 1; row <= NUM_TILES_PER_SIDE; ++row) {
            xPos = x;
            for(col = 1; col <= NUM_TILES_PER_SIDE; ++col) {
                Rectangle rect = new Rectangle(xPos, yPos, width, width);
                rect.setColor(randomColor());
                rect.fill();
                xPos += width; //Go to next column
            }
            yPos += width; //Go to next row
        }
    
    }
    
    /**
     * Randomly returns a Color object either ed, green, blue, yellow, magenta, and cyan.
     * @return color Returns a random color value.
     */
    public Color randomColor() {
        switch(generator.nextInt(6)) {
            case RED:
                return Color.RED;
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case MAGENTA:
                return Color.MAGENTA;
            case CYAN:
                return Color.CYAN;
            
        }
        return null;
    }
}
