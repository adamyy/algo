package bit_manipulation;

public class CountOne {
  public static int countOne(int n) {
    int count = 0;
    while (n > 0) {
      n = n & (n-1);
      count++;
    }
    return count;
  }
}
