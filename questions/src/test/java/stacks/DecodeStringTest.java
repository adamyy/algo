package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DecodeStringTest {

  @Test
  public void decodeString() {
    assertThat(DecodeString.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    assertThat(DecodeString.decodeString("3[a2[c]]")).isEqualTo("accaccacc");
    assertThat(DecodeString.decodeString("2[abc]3[cd]ef")).isEqualTo("abcabccdcdcdef");
    assertThat(DecodeString.decodeString("10[leetcode]"))
        .isEqualTo("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");
  }
}