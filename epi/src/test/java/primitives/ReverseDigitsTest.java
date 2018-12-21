package primitives;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ReverseDigitsTest {

  @Test
  public void reverse() {
    assertThat(ReverseDigits.reverse(42)).isEqualTo(24);
    assertThat(ReverseDigits.reverse(-314)).isEqualTo(-413);
  }
}