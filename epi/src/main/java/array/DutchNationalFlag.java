package array;

public class DutchNationalFlag {

  /**
   * Write a program that takes an array A and an index i into A,
   * and rearranges the elements such that all elements less than A[i] (the "pivot") appear first,
   * followed by elements equal to the pivot, followed by elements greater than the pivot.
   */
  public static void arrange(int[] arr, int i) {
    if (arr == null || arr.length <= 1) return; // no need to pivot

    // swap the pivot element with the first element for later
    int pivot = arr[i];

    // then pivot the array until lo >= hi
    int lo = 1;
    int hi = arr.length - 1;
    while (true) {
      while (arr[lo] < pivot) lo++;
      while (arr[hi] > pivot ) hi--;
      swap(arr, lo++, hi--);
      if (lo >= hi) break;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
