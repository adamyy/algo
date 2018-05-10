package jparkie.sorting;

public class QuickSort {
  public static int[] quickSort(int[] S) {
    return quickSort(S, 0, S.length - 1);
  }

  private static int[] quickSort(int[] S, int lowIndex, int highIndex) {
    if (highIndex <= lowIndex) return S;

    int pivot = partition(S, lowIndex, highIndex);
    quickSort(S, lowIndex, pivot - 1);
    quickSort(S, pivot + 1, highIndex);

    return S;
  }

  private static int partition(int[] S, int lowIndex, int highIndex) {
    int i = lowIndex;
    int j = highIndex + 1;

    int sentinel = S[lowIndex];

    while(true) {
      while (S[++i] < sentinel) {
        if (i == highIndex) break;
      }

      while (S[--j] > sentinel) {
        if (j == lowIndex) break;
      }

      if (i >= j) break;

      int temp = S[i];
      S[i] = S[j];
      S[j] = temp;
    }

    S[lowIndex] = S[j];
    S[j] = sentinel;

    return j;
  }
}
