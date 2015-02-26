
public class Number
{
    //provide instance variable(s)
    private double number;
    
    //provide a constructor that takes a double
    Number(double num) {
        number = num;
    }
    
    //provide the getMagnitude method
    public String getMagnitude() {
        String magnitude = null;
        double absoluteNum = Math.abs(number);
        if (absoluteNum > 1000000) { magnitude = "large"; }
        else if (absoluteNum >= 1) { magnitude = "average"; }
        else { magnitude = "small"; }
        
        return magnitude;
    }
}
