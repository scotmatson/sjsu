/**
  *  Author:  Scot Matson
  *  Date:    2014/08/31
  *  Course:  cs49c
  *  Section: 1
  *  Assn:    hw01
  *  Desc:    Given any two non-zero integers, the GCD function will
  *           return the greatest common divisor of the pair.
  **/

int GCD(int m, int n) {

  int divisor, GCD;

  if (m != 0 && n != 0) {
    if (m < 0)
      m *= -1;
    if (n < 0)
      n *= -1;

    /**
      *   Initializing the divisor to the smallest
      *   of the two given values since no value
      *   greater than this could divide evenly
      *   into both values.
      **/
    if (m < n)
      divisor = m;
    else
      divisor = n;

    /**
      *   Decrementing the divisor until both
      *   given values divide evenly.
      **/
    for(; divisor > 0; --divisor) {
      if((m % divisor) == 0 && (n % divisor) == 0) {

        /**
          *   If this point is reached, we have found our GCD
          *   and will break out of the loop.
          **/
        GCD = divisor;
        divisor = 0;
      }
    }
    return GCD;
  }
  else
    return -1;
}

