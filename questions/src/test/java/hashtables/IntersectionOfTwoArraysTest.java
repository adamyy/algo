package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class IntersectionOfTwoArraysTest {

  @Test
  public void intersect() {
    assertThat(IntersectionOfTwoArrays.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
        .isEqualTo(new int[]{2, 2});
  }

  @Test
  public void intersectTwoPointers() {
    assertThat(IntersectionOfTwoArrays.intersectTwoPointers(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
        .isEqualTo(new int[]{2, 2});
  }
}