package recursions_dynamic_programming;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class ParenthesizesTest {

  @Test
  public void parenthesizes() {
    assertThat(Parenthesizes.parenthesizes(3)).containsExactly(
        "((()))", "(()())", "(())()", "()(())", "()()()"
    );
  }
}