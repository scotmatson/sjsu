public class HighTemperatureMinderTester
{
    public static void main(String[] args)
    {
        int[] temperatures = {-5, 20, 17, -2, 30, 28, -3, -1};
        HighTemperatureMinder minder = 
            new HighTemperatureMinder(temperatures);        
        double biggestChange = minder.biggestChange();
        System.out.println("Biggest change: " + biggestChange);
        System.out.println("Expected: 32.0");
        
        temperatures = new int[0];
        HighTemperatureMinder minder2 = 
           new HighTemperatureMinder(temperatures);
        biggestChange = minder2.biggestChange();
        System.out.println("Biggest change: " + biggestChange);
        System.out.println("Expected: 0.0");
        
        int[] temperatures2 = {-5, 20, 17, -2};
        HighTemperatureMinder minderDifferentLength = 
           new HighTemperatureMinder(temperatures2);
        biggestChange = minderDifferentLength.biggestChange();
        System.out.println("Biggest change: " + biggestChange);
        System.out.println("Expected: 25.0");
        
        //first few elements are the same but they are 
        //different lengths
        System.out.println("The same: " + minderDifferentLength.theSame(minder));
        System.out.println("Expected: false");
        
        int[] temperatures3 = {-5, 20, 17, -2, 15, 28, -3, -1};
        HighTemperatureMinder minderDifferent = 
           new HighTemperatureMinder(temperatures3);
        
        //contain different data
        System.out.println("The same: " + minder.theSame(minderDifferent));
        System.out.println("Expected: false");
        
        int[] temperatures4 = {-5, 20, 17, -2, 30, 28, -3, -1};
        HighTemperatureMinder minderSame = 
           new HighTemperatureMinder(temperatures4);
        //contaon same data;
        System.out.println("The same: " + minder.theSame(minderSame));
        System.out.println("Expected: true");
           
    }
}