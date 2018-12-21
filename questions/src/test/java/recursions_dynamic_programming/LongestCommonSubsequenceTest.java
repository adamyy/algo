package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestCommonSubsequenceTest {

  @Test
  public void longestCommonSubsequence() {
//    assertThat(LongestCommonSubsequence
//        .longestCommonSubsequence(new int[]{1, 3, 4, 5}, new int[]{2, 3, 4}))
//        .isEqualTo(new int[]{3, 4});
  }

  @Test
  public void longestCommonSubstring() {
    assertThat(LongestCommonSubsequence.longestCommonSubstring("ABCDGH", "AEDFHR"))
        .isEqualTo("ADH".length());
    assertThat(LongestCommonSubsequence.longestCommonSubstring("AGGTAB", "GXTXAYB"))
        .isEqualTo("GTAB".length());
  }
}