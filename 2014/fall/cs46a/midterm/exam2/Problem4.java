
/**
9602502
Do not remove your student ID
Trace this method call. Put each variable change on a separate line.  
There are no line numbers since a line may be executed many times in a loop

       Problem4 test = new Problem4();
       System.out.println(test.mystery("wallpaper"));
 */
public class Problem4
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
