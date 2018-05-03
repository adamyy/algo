package strings;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class AllUniqueCharactersTest {

  @Test
  public void isUnique() {
    assertThat(AllUniqueCharacters.isUnique("abcde")).isTrue();
    assertThat(AllUniqueCharacters.isUnique("abcdb")).isFalse();
  }
}