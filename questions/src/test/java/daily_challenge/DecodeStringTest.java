package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DecodeStringTest {

  @Test
  public void decode() {
    assertThat(DecodeString.decode("111")).isEqualTo(3);
    assertThat(DecodeString.decode("101")).isEqualTo(1);
    assertThat(DecodeString.decode("0")).isEqualTo(0);
    assertThat(DecodeString.decode("10")).isEqualTo(1);
  }
}