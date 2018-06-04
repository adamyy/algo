package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class KClosestElementsTest {

  @Test
  public void kClosestElements() {
    assertThat(KClosestElements
        .kClosestElements(new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}, 4, 35)
    ).containsExactly(30, 35, 39, 42);
  }
}