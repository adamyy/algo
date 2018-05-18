package hashtables;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class GroupAnagramsTest {

  @Test
  public void groupAnagrams() {
    assertThat(GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}))
        .containsExactly(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );
  }
}