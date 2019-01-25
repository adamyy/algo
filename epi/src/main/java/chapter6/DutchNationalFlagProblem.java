package chapter6;

/**
 * Write a program that takes an array A and an index i into A,
 * and rearranges the elements such that all elements less than A[i] (the "pivot") appear first,
 * followed by elements equal to the pivot, followed by elements greater than the pivot.
 * Hint: Think about the partition step in quicksort.
 */
public class DutchNationalFlagProblem {
  public void arrange(int[] arr, int pivotIndex) {
    int pivot = arr[pivotIndex];
    int smaller = 0, equal = 0, larger = arr.length;
    while (equal < larger) {
      if (arr[equal] < pivot) {
        swap(arr, smaller++, equal++);
      } else if (arr[equal] == pivot) {
        equal++;
      } else { // arr[equal] > pivot
        swap(arr, equal, --larger);
      }
    }
  }

  private void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
