package recursions_dynamic_programming;

/**
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using the *operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */
public class MinProduct {
  public static int minProduct(int x, int y) {
    int smaller = Math.min(x, y);
    int bigger = Math.max(x, y);
    return minProduct(smaller, bigger, new int[smaller + 1]);
  }

  private static int minProduct(int smaller, int bigger, int[] memo) {
    if (smaller == 0) return 0;
    if (smaller == 1) return bigger;
    if (memo[smaller] > 0) return memo[smaller];

    int s = smaller >> 1;
    int side1 = minProduct(s, bigger, memo);
    int side2 = smaller % 2 == 1 ?  minProduct(smaller - s, bigger, memo) : side1;

    memo[smaller] = side1 + side2;
    return memo[smaller];
  }
}
