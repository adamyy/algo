package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DecodeStringTest {

  @Test
  public void decode() {
    assertThat(DecodeString.decode("111")).isEqualTo(3);
  }
}