package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class MagicIndexTest {

  @Test
  public void magicIndex() {
    assertThat(MagicIndex.magicIndex(new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}))
        .isEqualTo(7);
  }
}