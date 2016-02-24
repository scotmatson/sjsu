
/**
 * Write a description of class PrimeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrimeTester
{
    public static String getPrimes(PrimeGenerator gen)
    {
        String primes = "";
        int next = gen.nextPrime();

        while (next > -1)
        {
            primes = primes + next + " ";
            next = gen.nextPrime();
        }

        return primes;
    }
    
    public static void main(String[] args) {
        PrimeGenerator gen = new PrimeGenerator(50);
        System.out.print(getPrimes(gen));
    }
}
