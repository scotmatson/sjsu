/**
 * Models a shape consisting of a cube connected 
 * to a rectange whose height is twice the side of 
 * the cube. The other two dimensions of the rectange are
 * the same as the side of the cude
 */
public class ElSolid
{
    private double side = 0;
    
    /**
     * A constructor that takes the side of the cube as
     * a double parameter.
     * @param side of the cube
     */
    public ElSolid(double side) {
        this.side = side;
    }
    
    /**
     * Returns the side of the object.
     * @return the side
     */
    public double getSide() {
        return side;
    }
    
    /**
     * Returns the volume of this el-solid
     * @return the volume
     */
    public double volume() {
        double cube = Math.pow(side, 3);
        double rectangle = (side * 2) * Math.pow(side, 2);
        return cube + rectangle;
    }
    
    /**
     * Changes the value of x by a given delta.
     * @param delta increases the value of all sides
     */
    public void grow(double delta) {
        this.side += delta;
    }
}
