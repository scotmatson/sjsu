
/**
 * Write a description of class FlowerViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlowerViewer {
    public static void main(String[] args) {
     final int BUD_WIDTH  = 30;
     final int BUD_HEIGHT = 30;
     final int PEDAL_WIDTH = 30;
     final int PEDAL_HEIGHT= 30;
     
     // Initialize objects which make up the parts of a flower
     Ellipse flwrBud = new Ellipse(50, 40, BUD_WIDTH, BUD_HEIGHT);
     Ellipse pedalTop = new Ellipse(50, 10, PEDAL_WIDTH, PEDAL_HEIGHT);
     Ellipse pedalRight = new Ellipse(80, 40, PEDAL_WIDTH, PEDAL_HEIGHT);
     Ellipse pedalBottom = new Ellipse(50, 70, PEDAL_WIDTH, PEDAL_HEIGHT);
     Ellipse pedalLeft = new Ellipse(20, 40, PEDAL_WIDTH, PEDAL_HEIGHT);
     
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
