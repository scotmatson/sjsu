public class Array2DManagerRunner
{
    public static void main(String[] args)
    {
        Array2DManager manager = new Array2DManager(5,4);
        System.out.println(manager.sum());
        System.out.println("Expected: 212");
        
        //Array2DManager manager2 = new Array2DManager(7,3);
        //System.out.println(manager2.sum());
        //System.out.println("Expected: 138");
    }
}