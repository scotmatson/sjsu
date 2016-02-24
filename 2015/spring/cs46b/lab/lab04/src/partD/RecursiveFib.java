package partD;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursiveFib
{

    public static long[] knownFibonaccivalues;

    public static void main(String[] args)
    {
        Logger.getGlobal().setLevel(Level.OFF);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        knownFibonaccivalues = new long[n+1];
        for (int i = 1; i <= n; i++)
        {
            long f = fib(i);
            System.out.println("fib(" + i + ") = " + f);
        }
    }

    /**
     Computes a Fibonacci number.
     @param n an integer
     @return the nth Fibonacci number
     */
    public static long fib(int n)
    {
        Logger.getGlobal().info("Entering fib. n=" + n);
        long result;
        if (n <= 2)
        {
            result = 1;
        }
        else
        {
            long first = fib(n - 1);
            long second = fib(n - 2);
            result = first + second;
        }
        knownFibonaccivalues[n] = result;

        Logger.getGlobal().info("Exiting fib. n=" + n);
        return result;
    }
}