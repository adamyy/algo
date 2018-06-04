package arrays;

import java.util.Random;

public class QuickSelect {
  public static int kthElementInUnsortedArray(int[] arr, int k) {
    if (k < 0 || k > arr.length) return -1;

    int begin = 0;
    int end = arr.length - 1;

    while (true) {
      int partition = randomPartition(arr, begin, end);
      if (partition > k - 1) {
        end = partition - 1;
      } else if (partition < k - 1) {
        begin = partition + 1;
      } else {
        return arr[partition];
      }
    }
  }

  private static Random random = new Random();

  private static int randomPartition(int[] arr, int start, int end) {
    int sectionLength = end - start + 1;
    int randomPivot = random.nextInt(sectionLength);
    swap(arr, start + randomPivot, end);
    return partition(arr, start, end);
  }

  private static int partition(int[] arr, int start, int end) {
    if (start > end) throw new IllegalArgumentException();
    if (start == end) return start;
    int i = start;
    int j = end + 1;

    int pivot = arr[start];

    while (true) {
      while (arr[++i] < pivot) {
        if (i == end) break;
      }
      while (arr[--j] > pivot) {
        if (j == start) break;
      }

      if (i >= j) break;

      swap(arr, i, j);
    }

    arr[start] = arr[j];
    arr[j] = pivot;

    return j;
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
