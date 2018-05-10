package jparkie.sorting;

public class RadixSort {
  public static int[] radixSort(int[] S) {
    int maximum = S[0];

    for (int index = 0; index < S.length; index++) {
      if (S[index] > maximum) maximum = S[index];
    }

    for (int exp = 1; (maximum / exp) > 0; exp *= 10) {
      countingSort(S, exp);
    }

    return S;
  }

  // counting sort of cardinality 10
  private static void countingSort(int[] S, int exp) {
    int counts[] = new int[10];
    int buffer[] = new int[S.length];

    for (int index = 0; index < S.length; index++) {
      counts[(S[index] / exp) % 10]++;
    }

    for (int index = 1; index < 10; index++) {
      counts[index] += counts[index - 1];
    }

    for (int index = 0; index < S.length; index++) {
      buffer[--counts[(S[index] / exp) % 10]] = S[index];
    }

    for (int index = 0; index < S.length; index++) {
      S[index] = buffer[index];
    }
  }
}
