package recursions_dynamic_programming;

/**
 * Magic Index: A magic index in an array A[ 0••• n -1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *
 * FOLLOW UP
 * What if the values are not distinct?
 */
public class MagicIndex {
  public static int magicIndex(int[] arr) {
    return magicIndex(arr, 0, arr.length - 1);
  }

  private static int magicIndex(int[] arr, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end) / 2;

    if (arr[mid] > mid) return magicIndex(arr, start, mid - 1);
    if (arr[mid] < mid) return magicIndex(arr, mid + 1, end);
    return mid;
  }
}
