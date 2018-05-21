package hashtables;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FindAllAnagramsInStringTest {

  @Test
  public void findAnagrams() {
    assertThat(FindAllAnagramsInString.findAnagrams("cbaebabacd", "abc"))
        .containsExactly(0, 6);
    assertThat(FindAllAnagramsInString.findAnagrams("abab", "ab"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagrams("aaa", "a"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagrams("aaa", "aa"))
        .containsExactly(0, 1);
    assertThat(FindAllAnagramsInString.findAnagrams("ccccbbbbaaaa","abc")).isEmpty();
  }

  @Test
  public void findAnagramsSimplified() {
    assertThat(FindAllAnagramsInString.findAnagramsSimplified("cbaebabacd", "abc"))
        .containsExactly(0, 6);
    assertThat(FindAllAnagramsInString.findAnagramsSimplified("abab", "ab"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagramsSimplified("aaa", "a"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagramsSimplified("aaa", "aa"))
        .containsExactly(0, 1);
    assertThat(FindAllAnagramsInString.findAnagramsSimplified("ccccbbbbaaaa","abc")).isEmpty();
  }

  @Test
  public void findAnagramsSlidingWindow() {
    assertThat(FindAllAnagramsInString.findAnagramsSlidingWindow("cbaebabacd", "abc"))
        .containsExactly(0, 6);
    assertThat(FindAllAnagramsInString.findAnagramsSlidingWindow("abab", "ab"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagramsSlidingWindow("aaa", "a"))
        .containsExactly(0, 1, 2);
    assertThat(FindAllAnagramsInString.findAnagramsSlidingWindow("aaa", "aa"))
        .containsExactly(0, 1);
    assertThat(FindAllAnagramsInString.findAnagramsSlidingWindow("ccccbbbbaaaa","abc")).isEmpty();
  }
}