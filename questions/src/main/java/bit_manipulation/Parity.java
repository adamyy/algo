package bit_manipulation;

/**
 * The parity of a binary word is 1 if the number of 1's in the word is odd; otherwise, it is 0.
 * For example, the parity of 1011 is 1, and the parity of 10001000 is 0.
 */
public class Parity {

  /**
   * Let k be the number of bits set to 1 in a particularly word,
   * then time complexity of this algorithm is O(k)
   */
  public static int parity(long x) {
    int result = 0;
    while (x != 0) {
      result ^= 1;
      // Drop the lowest set bit of x
      x = x & (x - 1);
    }
    return result;
  }
}
