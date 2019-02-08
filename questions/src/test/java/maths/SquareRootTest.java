package maths;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SquareRootTest {

  @Test
  public void sqrt() {
    assertThat(SquareRoot.sqrt(2)).isEqualTo(1);
    assertThat(SquareRoot.sqrt(4)).isEqualTo(2);
    assertThat(SquareRoot.sqrt(8)).isEqualTo(2);
    assertThat(SquareRoot.sqrt(9)).isEqualTo(3);
    assertThat(SquareRoot.sqrt(10)).isEqualTo(3);
    assertThat(SquareRoot.sqrt(15)).isEqualTo(3);
    assertThat(SquareRoot.sqrt(16)).isEqualTo(4);
  }
}