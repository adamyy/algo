package bit_manipulation;

public class SumOfTwoIntegers {
  public static int sumOfTwoIntegers(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;
    return sumOfTwoIntegers(a ^ b, (a & b) << 1);
  }
}
