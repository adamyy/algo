package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SubArraysWithKDifferentIntegerTest {

  @Test
  public void subArraysWithKDistinct() {
    assertThat(SubArraysWithKDifferentInteger.subArraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2))
        .isEqualTo(7);
    assertThat(SubArraysWithKDifferentInteger.subArraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3))
        .isEqualTo(3);
  }
}