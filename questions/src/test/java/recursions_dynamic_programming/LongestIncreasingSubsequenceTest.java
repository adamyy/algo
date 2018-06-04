package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LongestIncreasingSubsequenceTest {

  @Test
  public void lengthOfLISTails() {
    assertThat(LongestIncreasingSubsequence.lengthOfLISTails(new int[]{10, 9, 2, 5, 3, 7, 101, 18}))
        .isEqualTo(4);
  }

  @Test
  public void lengthOfLISBruteForce() {
    assertThat(LongestIncreasingSubsequence.lengthOfLISBruteForce(new int[]{10, 9, 2, 5, 3, 7, 101, 18}))
        .isEqualTo(4);
  }

  @Test
  public void lengthOfLISBinarySearch() {
    assertThat(LongestIncreasingSubsequence.lengthOfLISBinarySearch(new int[]{10, 9, 2, 5, 3, 7, 101, 18}))
        .isEqualTo(4);
    assertThat(LongestIncreasingSubsequence.lengthOfLISBinarySearch(new int[]{1, 2, 3, 4, 5}))
        .isEqualTo(5);
    assertThat(LongestIncreasingSubsequence.lengthOfLISBinarySearch(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}))
        .isEqualTo(6);
  }
}