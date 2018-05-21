package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FirstUniqueCharacterTest {

  @Test
  public void firstUniqueCharacter() {
    assertThat(FirstUniqueCharacter.firstUniqueCharacter("leetcode")).isEqualTo(0);
    assertThat(FirstUniqueCharacter.firstUniqueCharacter("loveleetcode")).isEqualTo(2);
    assertThat(FirstUniqueCharacter.firstUniqueCharacter("cc")).isEqualTo(-1);
    assertThat(FirstUniqueCharacter.firstUniqueCharacter("cac")).isEqualTo(1);
    assertThat(FirstUniqueCharacter.firstUniqueCharacter("dddccdbba")).isEqualTo(8);
  }
}