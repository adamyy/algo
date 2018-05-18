package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PermutationWithoutDupsTest {

  @Test
  public void permutations() {
    assertThat(PermutationWithoutDups.permutations("abc")).containsExactly(
        "abc", "acb", "bac", "bca", "cab", "cba"
    );
  }
}