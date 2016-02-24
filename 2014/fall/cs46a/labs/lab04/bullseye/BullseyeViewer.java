
public class BullseyeViewer
{
    public static void main(String[] args)
    {
        BullsEye eye1 = new BullsEye(100, 100);
        eye1.draw();
        
        BullsEye eye2 = new BullsEye(200, 200);
        eye2.grow(60);
        eye2.draw();

        
        BullsEye eye3 = new BullsEye(50, 300);
        eye3.grow(-30);
        eye3.draw();
    }
}