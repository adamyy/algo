package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeEnumeration {
  public static List<Integer> primes(int k) {
    List<Integer> result = new ArrayList<>();
    if (k <= 1) return result;

    boolean[] isPrime = new boolean[k + 1];
    Arrays.fill(isPrime, true);

    for (int i = 2; i <= k; i++) {
      if (isPrime[i]) {
        result.add(i);
        // sieve non primes
        for (int j = i; j <= k; j += i) {
          isPrime[j] = false;
        }
      }
    }

    return result;
  }
}
