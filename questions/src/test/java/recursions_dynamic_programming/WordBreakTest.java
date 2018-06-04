package recursions_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class WordBreakTest {

  @Test
  public void wordBreak() {
    assertThat(WordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"))).isTrue();
    assertThat(WordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"))).isTrue();
    assertThat(WordBreak.wordBreak("catsandog", Arrays.asList("cats","dog", "sand", "and", "cat"))).isFalse();
  }
}