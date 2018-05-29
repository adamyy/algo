package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CalculatorWithBracketsTest {

  @Test
  public void calculate() {
    assertThat(CalculatorWithBrackets.calculate("1 + 1")).isEqualTo(2);
    assertThat(CalculatorWithBrackets.calculate(" 2-1 + 2 ")).isEqualTo(3);
    assertThat(CalculatorWithBrackets.calculate("(1+(4+5+2)-3)+(6+8)")).isEqualTo(23);
  }
}