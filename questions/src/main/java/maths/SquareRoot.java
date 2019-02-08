package maths;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SquareRoot {
  public static int sqrt(int x) {
    if (x <= 1) return x;
    int min = 1, max = x;
    while (min <= max) {
      int mid = (min + max) / 2;
      int prod = mid * mid;
      if (prod > x) {
        max = mid - 1;
      } else if (prod < x) {
        min = mid + 1;
      } else {
        return mid;
      }
    }
    return min - 1;
  }
}
