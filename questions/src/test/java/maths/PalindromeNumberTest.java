package maths;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PalindromeNumberTest {

  @Test
  public void isPalindrome() {
    assertThat(PalindromeNumber.isPalindrome(0)).isTrue();
    assertThat(PalindromeNumber.isPalindrome(121)).isTrue();
    assertThat(PalindromeNumber.isPalindrome(1221)).isTrue();
    assertThat(PalindromeNumber.isPalindrome(12021)).isTrue();
    assertThat(PalindromeNumber.isPalindrome(1210)).isFalse();
    assertThat(PalindromeNumber.isPalindrome(-121)).isFalse();
    assertThat(PalindromeNumber.isPalindrome(10)).isFalse();
  }
}