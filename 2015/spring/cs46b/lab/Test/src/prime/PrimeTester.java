package prime;

/**
 * Created by scot on 3/6/15.
 */
public class PrimeTester {

    public static void main(String[] args) {
        boolean prime = false;
        int n = 4;
        int d = n-1;
        while (!prime) {
            prime = isPrime(n, d);
            System.out.printf("n = %d\nd = %d\nprime = %s\n", n, d, prime);
            --d;

            if (d == 0) {
                System.out.printf("Zero reached");

            }
        }
    }

    public static boolean isPrime(int n, int d) {
        if (n < 2) {
            return false;
        }
        if (d ==1) {
            return true;
        } else {
            if (n % d == 0 ) {
                return false;
            } else
                return (isPrime(n, d-1));
        }
    }
}


