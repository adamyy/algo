package arrays;

public class DeleteDuplicatesFromSortedArray {
  // Returns the number of valid entries after deletion
  public static int deleteDuplicates(int[] arr) {
    int currIndex = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[currIndex] != arr[i]) {
        arr[++currIndex] = arr[i];
      }
    }
    return currIndex + 1;
  }
}
