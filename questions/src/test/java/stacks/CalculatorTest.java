package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class CalculatorTest {

  @Test
  public void calculate() {
    assertThat(Calculator.calculate("3+2*2")).isEqualTo(7);
    assertThat(Calculator.calculate(" 3/2 ")).isEqualTo(1);
    assertThat(Calculator.calculate(" 3+5 / 2 ")).isEqualTo(5);
    assertThat(Calculator.calculate("10 + 2 * 6")).isEqualTo(22);
    assertThat(Calculator.calculate("10 * 2 + 6")).isEqualTo(26);
    assertThat(Calculator.calculate("100000000/1/2/3/4/5/6/7/8/9/10")).isEqualTo(27);
  }
}