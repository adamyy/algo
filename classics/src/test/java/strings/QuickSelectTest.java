package strings;

import arrays.QuickSelect;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class QuickSelectTest {

  @Test
  public void kthElementInUnsortedArray() {
    assertThat(
        QuickSelect.kthElementInUnsortedArray(new int[]{7, 10, 4, 3, 20, 15}, 3)
    ).isEqualTo(7);
    assertThat(
        QuickSelect.kthElementInUnsortedArray(new int[]{7, 10, 4, 3, 20, 15}, 4)
    ).isEqualTo(10);
  }
}