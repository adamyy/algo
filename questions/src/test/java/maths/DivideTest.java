package maths;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class DivideTest {

  @Test
  public void divide() {
    assertThat(Divide.divide(10, 3)).isEqualTo(3);
    assertThat(Divide.divide(7, -3)).isEqualTo(-2);
    assertThat(Divide.divide(1, 1)).isEqualTo(1);
    assertThat(Divide.divide(1, -1)).isEqualTo(-1);
  }
}