package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MediumOfTwoSortedArraysTest {

  @Test
  public void findMedianSortedArrays() {
    assertThat(MediumOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}))
        .isEqualTo(2.0);
    assertThat(MediumOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{}))
        .isEqualTo(2.0);
    assertThat(MediumOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}))
        .isEqualTo(2.5);
    assertThat(MediumOfTwoSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{1}))
        .isEqualTo(1.0);
  }
}