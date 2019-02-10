package searching;

public class BinarySearch {
  public static int binarySearch(int[] S, int key) {
    int lowIndex = 0;
    int highIndex = S.length - 1;

    while (lowIndex <= highIndex) {
      int midPoint = lowIndex + (highIndex - lowIndex) / 2;
      if (key < S[midPoint]) {
        highIndex = midPoint - 1;
      } else if (key > S[midPoint]) {
        lowIndex = midPoint + 1;
      } else {
        return midPoint;
      }
    }

    return -1;
  }
}
