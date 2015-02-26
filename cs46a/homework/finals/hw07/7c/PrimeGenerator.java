
/**
 * PrimeGenerator represents the sequence of prime numbers 
 * less than a specified number.
 * 
 * @author (Scot Matson) 
 * @version (20141015)
 */
public class PrimeGenerator
{
    private int limit;
    private int currentPrime;

    /**
     * Creates a PrimeGenerator which can get primes up to the limit
     * @param limit the number that all the primes must be less than
     */
    public PrimeGenerator(int limit)
    {
        this.limit = limit;
        currentPrime = 2;
    }

    /**
     * Returns the next prime in the sequence starting with 2 
     * up to the last prime less than limit.
     * If there are no more primes, the method returns -1.
     * @return prime The next prime number in the sequence.
     */
    public int nextPrime() {
        int prime = -1;
        
        while (!isPrime(currentPrime)) { //If the current value is not prime
            ++currentPrime; //Increment our value until we've found a prime
        }
        if (currentPrime < limit) {
            prime = currentPrime;
        }
        
        ++currentPrime;
        return prime;        
    }

    /**
     * Returns true if n is prime otherwise returns false.
     * @param n User input to be evaluated as prime.
     * @return isPrime true if number input is prime.
     */
    public boolean isPrime(int n) {
        boolean isPrime = false;
        int i = 2;
        int counter = 0;

        // Test each number between 2 and n
        while (i <= n) {
            // Each number which divides easily increments our counter
            if (n % i == 0) ++counter;
            ++i;
        }

        // A counter of one confirms that n is in fact prime
        if (counter == 1) {
            isPrime = true;
        }

        return isPrime;
    }

    /**
     * Sets a new limit for this PrimeGenerator and resets the currentPrime
     * @param newLimit Number to set as limit.
     */
    public void setLimit(int newLimit) {
        limit = newLimit;
        currentPrime = 2;
    }
}
