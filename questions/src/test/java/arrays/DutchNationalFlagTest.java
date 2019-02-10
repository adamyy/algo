package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DutchNationalFlagTest {

  @Test
  public void arrange() {
    int[] arrA = { 0, 1, 2, 0, 2, 1, 1 };
    DutchNationalFlag.arrange(arrA, 3);
    assertThat(arrA).isEqualTo(new int[]{ 0, 0, 2, 1, 2, 1, 1 });

    int[] arrB = { 0, 1, 2, 0, 2, 1, 1 };
    DutchNationalFlag.arrange(arrB, 2);
    assertThat(arrB).isEqualTo(new int[]{ 0, 1, 1, 0, 1, 2, 2 });
  }
}