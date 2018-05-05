package strings;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class StringCompressionTest {

  @Test
  public void stringCompression() {
    assertThat(StringCompression.stringCompression("aabcccccaaa"))
        .isEqualTo("a2b1c5a3");
  }
}