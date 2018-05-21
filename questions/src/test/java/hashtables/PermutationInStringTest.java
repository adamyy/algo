package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PermutationInStringTest {

  @Test
  public void checkInclusion() {
    assertThat(PermutationInString.checkInclusion("abc", "ccccbbbbaaaa")).isFalse();
    assertThat(PermutationInString.checkInclusion("ab", "eidbaooo")).isTrue();
    assertThat(PermutationInString.checkInclusion("ab", "eidboaoo")).isFalse();
  }
}