package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

  @Test
  public void lengthOfLongestSubstring() {
    LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
    assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
    assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
  }
}