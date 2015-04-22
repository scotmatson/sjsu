package problem01;

public class StudentTester {
    public static void main(String[] args)
    {
        int n = 10;
        Student s = new Student("Sam");
        for(int i = 1; i <= n; i++)
        {
            s.addGrade(i);
        }  //loop

        double average = s.getAverage();   //line 11

        System.out.println(s.getName() + " " + average);
        System.out.println("Expected: Sam " + (1 + n)/2.0);
    }
}