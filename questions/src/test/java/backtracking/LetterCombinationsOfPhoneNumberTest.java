package backtracking;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LetterCombinationsOfPhoneNumberTest {

  @Test
  public void letterCombinations() {
    LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();

    assertThat(solution.letterCombinations("23")).containsExactly(
        "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
    );
  }
}