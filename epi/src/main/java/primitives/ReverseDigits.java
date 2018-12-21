package primitives;

public class ReverseDigits {
  public static int reverse(int x) {
    boolean isNegative = x < 0;
    x = Math.abs(x);
    int result = 0;
    while (x != 0) {
      result = result * 10 + x % 10;
      x /= 10;
    }
    return isNegative ? -1 * result : result;
  }
}
