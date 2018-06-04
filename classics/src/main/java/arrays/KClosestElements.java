package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a !!!!!sorted!!!!! array arr[] and a value X, find the k closest elements to X in arr[].
 * Examples:
 *
 * Input: K = 4, X = 35
 *        arr[] = {12, 16, 22, 30, 35, 39, 42,
 *                45, 48, 50, 53, 55, 56}
 * Output: 30 39 42 45
 */
public class KClosestElements {
  public static List<Integer> kClosestElements(int[] arr, int k, int target) {
    int[] dist = new int[arr.length];
    for (int i = 0; i < arr.length; i++) dist[i] = Math.abs(arr[i] - target);

    // quick select on dist
    int start = 0;
    int end = arr.length - 1;
    while (true) {
      int partition = randomPartition(dist, arr, start, end);
      if (partition == k) break;
      if (partition > k) {
        end = partition - 1;
      } else {
        start = partition + 1;
      }
    }


    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) result.add(arr[i]);

    return result;
  }

  private static Random random = new Random();
  private static int randomPartition(int[] arr, int[] shadow, int start, int end) {
    int length = end - start + 1;
    int pivot = random.nextInt(length);
    swap(arr, shadow, start, end - pivot);
    return partition(arr, shadow, start, end);
  }

  // always pick the first element to pivot
  private static int partition(int[] arr, int[] shadow, int start, int end) {
    int pivot = arr[start];
    int pivotShadow = shadow[start];
    int i = start;
    int j = end + 1;

    while (true) {
      while (arr[++i] < pivot && i != end);
      while (arr[--j] > pivot && j != start);
      if (i >= j) break;

      swap(arr, shadow, i, j);
    }

    arr[start] = arr[j];
    arr[j] = pivot;
    shadow[start] = shadow[j];
    shadow[j] = pivotShadow;

    return j;
  }

  private static void swap(int[] arr, int[] shadow, int first, int second) {
    swap(arr, first, second);
    swap(shadow, first, second);
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
