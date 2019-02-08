package daily_challenge;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 *
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class LargestSumNonAdjacentIntegers {
  public static int max(int[] arr) {
    int takePrev = 0, skipPrev = 0;
    for (int num: arr) {
      int takeCurr = num + skipPrev;
      // advance
      skipPrev = Math.max(skipPrev, takePrev);
      takePrev = takeCurr;
    }
    return Math.max(takePrev, skipPrev);
  }
}
