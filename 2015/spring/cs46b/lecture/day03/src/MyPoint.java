import java.awt.*; // abstract windows.... t????

/**
 * Created by scot on 2/2/15.
 */
public class MyPoint extends Point {

    public MyPoint() {

        super(0, 0); // Passing coordinates to the super class constructor for the Point class
    }

    public void move(int x, int y, boolean relative) {
        if(relative == false) {
            super.move(x, y);
        }
        else {
            int newX = (int) super.getX() + x;
            int newY = (int) super.getY() + y;
            super.move(newX, newY);
        }
    }

    @Override // Turns on compiler warnings
    public String toString() {
        return "MyPoint[x=" + super.getX() + ", y=" + super.getY() + "]";
    }
}
