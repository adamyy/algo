package arrays;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SortColorsTest {

  @Test
  public void sortColors() {
    assertThat(SortColors.sortColors(new int[]{2, 0, 2, 1, 1, 0}))
        .isEqualTo(new int[]{0, 0, 1, 1, 2, 2});
    assertThat(SortColors.sortColors(new int[]{2, 0, 1}))
        .isEqualTo(new int[]{0, 1, 2});
    assertThat(SortColors.sortColors(new int[]{1, 2, 0}))
        .isEqualTo(new int[]{0, 1, 2});
  }
}