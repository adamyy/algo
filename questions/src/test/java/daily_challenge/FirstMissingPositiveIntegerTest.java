package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FirstMissingPositiveIntegerTest {

  @Test
  public void find() {
    assertThat(FirstMissingPositiveInteger.find(new int[]{3, 4, -1, 1})).isEqualTo(2);
    assertThat(FirstMissingPositiveInteger.find(new int[]{1, 2, 0})).isEqualTo(3);
    assertThat(FirstMissingPositiveInteger.find(new int[]{7, 8, 9, 11, 12})).isEqualTo(1);
  }
}