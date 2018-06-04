package strings;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class KMPPatternMatchingTest {

  @Test
  public void match() {
    assertThat(
        KMPPatternMatching.match("AAAAA".toCharArray(), "AA".toCharArray())
    ).containsExactly(0, 1, 2, 3);
    assertThat(
        KMPPatternMatching.match("THIS IS A TEST TEXT".toCharArray(), "TEST".toCharArray())
    ).containsExactly(10);
    assertThat(
        KMPPatternMatching.match("AABAACAADAABAABA".toCharArray(), "AABA".toCharArray())
    ).containsExactly(0, 9, 12);
  }

  @Test
  public void buildNextTable() {
    assertThat(KMPPatternMatching.buildNextTable("ABCDABD".toCharArray()))
        .isEqualTo(new int[]{-1, 0, 0, 0, 0, 1, 2});
  }
}