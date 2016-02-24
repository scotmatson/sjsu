//ID9602502
/**
 * Problem6 has a draw method that can draw an upside-down
 * pyramid of hollow rectangles.
 *
 * The first row has  5 hollow rectangles.
 * Each subsequent method has one less until the last row only
 * contains 1 figure.
 * 
 * Each figure has a width and height of 20
 * There is a gap of 2 between the column and between the rows.
 * 
 * The first figure in each row is yellow. Subsequent 
 * figures alternate between yellow and cyan 
 * Use the colors predefined in the Color class
 * 
 * The x, y coordinate of the upper left hand corner of the
 *  hollow rectangles
 *  is (0,0)
 *  
 * You will upload Problem6.java
 */
public class Problem6
{
    //15 rectangles
    public void drawUpsideDownRectanglePyramid() {
        //Instantiate Rectangles
        Rectangle row1pos1 = new Rectangle(0, 0, 20, 20);
        Rectangle row1pos2 = new Rectangle(22, 0, 20, 20);
        Rectangle row1pos3 = new Rectangle(44, 0, 20, 20);
        Rectangle row1pos4 = new Rectangle(66, 0, 20, 20);
        Rectangle row1pos5 = new Rectangle(88, 0, 20, 20);
        Rectangle row2pos1 = new Rectangle(11, 22, 20, 20);
        Rectangle row2pos2 = new Rectangle(33, 22, 20, 20);
        Rectangle row2pos3 = new Rectangle(55, 22, 20, 20);
        Rectangle row2pos4 = new Rectangle(77, 22, 20, 20);
        Rectangle row3pos1 = new Rectangle(22, 44, 20, 20);
        Rectangle row3pos2 = new Rectangle(44, 44, 20, 20);
        Rectangle row3pos3 = new Rectangle(66, 44, 20, 20);
        Rectangle row4pos1 = new Rectangle(33, 66, 20, 20);
        Rectangle row4pos2 = new Rectangle(55, 66, 20, 20);
        Rectangle row5pos1 = new Rectangle(44 ,88, 20, 20);

        //Yellow Rectangles
        row1pos1.setColor(Color.YELLOW);
        row1pos3.setColor(Color.YELLOW);
        row1pos5.setColor(Color.YELLOW);
        row2pos1.setColor(Color.YELLOW);
        row2pos3.setColor(Color.YELLOW);
        row3pos1.setColor(Color.YELLOW);
        row3pos3.setColor(Color.YELLOW);
        row4pos1.setColor(Color.YELLOW);
        row5pos1.setColor(Color.YELLOW);

        //Cyan Rectangles
        row1pos2.setColor(Color.CYAN);
        row1pos4.setColor(Color.CYAN);
        row2pos2.setColor(Color.CYAN);
        row2pos4.setColor(Color.CYAN);
        row2pos2.setColor(Color.CYAN);
        row2pos4.setColor(Color.CYAN);
        row3pos2.setColor(Color.CYAN);
        row4pos2.setColor(Color.CYAN);

        //Draw the pyramid
        row1pos1.draw();
        row1pos2.draw();
        row1pos3.draw();
        row1pos4.draw();
        row1pos5.draw();
        row2pos1.draw();
        row2pos2.draw();
        row2pos3.draw();
        row2pos4.draw();
        row3pos1.draw();
        row3pos2.draw();
        row3pos3.draw();
        row4pos1.draw();
        row4pos2.draw();
        row5pos1.draw();
    }
}

