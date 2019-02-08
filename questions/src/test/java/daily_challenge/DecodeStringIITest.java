package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DecodeStringIITest {

  @Test
  public void numDecodings() {
    assertThat(DecodeStringII.decode("*")).isEqualTo(9);
    assertThat(DecodeStringII.decode("1*")).isEqualTo(18);
    assertThat(DecodeStringII.decode("**")).isEqualTo(96);
    assertThat(DecodeStringII.decode("*9*9*")).isEqualTo(900);
    assertThat(DecodeStringII.decode("*9*1*")).isEqualTo(1800);
    assertThat(DecodeStringII.decode("*10*1")).isEqualTo(99);
    assertThat(DecodeStringII.decode("********************")).isEqualTo(104671669);
  }
}