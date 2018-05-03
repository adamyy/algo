package sorting;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class RadixSortTest {

  @Test
  public void radixSort() {
    int[] S = new int[] { 7, 5, 0, 1, 6, 2, 4, 2 };

    int[] sortedArray = RadixSort.radixSort(S);

    assertThat(sortedArray).isEqualTo(new int[] { 0, 1, 2, 2, 4, 5, 6, 7 });
  }
}