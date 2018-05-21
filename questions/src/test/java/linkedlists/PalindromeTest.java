package linkedlists;

import lib.ListNode;
import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PalindromeTest {

  @Test
  public void isPalindromeSimplified() {
    assertThat(Palindrome.isPalindromeSimplified(null)).isTrue();
    assertThat(Palindrome.isPalindromeSimplified(ListNode.fromArray(1, 2))).isFalse();
    assertThat(Palindrome.isPalindromeSimplified(ListNode.fromArray(1, 2, 2, 1))).isTrue();
  }
}