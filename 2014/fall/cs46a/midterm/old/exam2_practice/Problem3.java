
/**
 * Write a description of class Tracing_string here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Problem3
{
    public String mystery(String str)
    {
        int max = 0;
        String result = "";
        while (str.length() > 0)
        {
            String ch = str.substring(0, 1);
            int count = 1;
            int j = str.indexOf(ch, 1);
            while (j != -1)
            {
                count++;
                j = str.indexOf(ch, j+1);
            }

            if (count == max)
            {
                result = result + ch;
            }
            else if (count > max)
            {
                result = ch;
                max = count;
            }
            str = str.replace(ch, "");
        }
        return result;
    }
}
