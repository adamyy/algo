package daily_challenge;

/**
 * This problem was asked by Stripe.
 *
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class FirstMissingPositiveInteger {
  public static int find(int[] arr) {
    if (arr.length == 0) return 1;
    final int bound = partition(arr, 0); // from 0 to bound - 1, all elements are bigger than 0
    for (int i = 0; i < bound; i++) {
      int oldVal = Math.abs(arr[i]);
      if (oldVal <= bound) {
        if (arr[oldVal - 1] > 0) {
          arr[oldVal - 1] *= -1;
        }
      }
    }

    for (int i = 0; i < bound; i++) {
      if (arr[i] > 0) return i + 1;
    }

    return bound + 1;
  }

  /**
   * Partition the array such that all the elements that are bigger than pivot occurs first in the array,
   * followed by the elements smaller than the pivot
   * @param arr
   * @param pivot
   * @return the index for which all elements smaller than index are bigger than pivot
   */
  private static int partition(int[] arr, int pivot) {
    int ret = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > pivot) {
        swap(arr, ret++, i);
      }
    }
    return ret;
  }

  private static void swap(int[] arr, int first, int second) {
    if (first == second) return;
    arr[first] ^= arr[second];
    arr[second] ^= arr[first];
    arr[first] ^= arr[second];
  }
}
