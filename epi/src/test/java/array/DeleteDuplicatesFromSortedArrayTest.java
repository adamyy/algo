package array;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DeleteDuplicatesFromSortedArrayTest {

  @Test
  public void deleteDuplicates() {
    int[] arr = { 2, 3, 5, 5, 7, 11, 11, 11, 13 };
    assertThat(
        DeleteDuplicatesFromSortedArray.deleteDuplicates(arr))
        .isEqualTo(6);
    assertThat(arr).isEqualTo(new int[]{2, 3, 5, 7, 11, 13, 11, 11, 13});
  }
}