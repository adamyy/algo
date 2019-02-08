package maths;

/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Power {
  public static double pow(double x, double n) {
    double res = 1;
    long absN = Math.abs((long)n);
    while (absN > 0) {
      if ((absN & 1) == 1) res *= x;
      x *= x;
      absN >>= 1;
    }
    return n >= 0 ? res : 1 / res;
  }
}
