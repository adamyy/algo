package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PermutationsWithDuplicatesTest {

  @Test
  public void permutation() {
    assertThat(PermutationsWithDuplicates.permutation("abb")).containsExactly(
        "abb", "bab", "bba"
    );
  }
}