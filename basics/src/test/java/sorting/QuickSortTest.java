package sorting;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;

public class QuickSortTest {

  @Test
  public void quickSort() {
    int[] S = new int[] { 7, 5, 0, 1, 6, 2, 4, 2 };

    int[] sortedArray = QuickSort.quickSort(S);

    assertThat(sortedArray).isEqualTo(new int[] { 0, 1, 2, 2, 4, 5, 6, 7 });
  }
}