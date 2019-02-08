package maths;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class PowerTest {

  @Test
  public void pow() {
    assertThat(Power.pow(2.0, 10)).isWithin(0.000001).of(1024.0);
    assertThat(Power.pow(2.1, 3)).isWithin(0.000001).of(9.261);
    assertThat(Power.pow(2.0, -2)).isWithin(0.000001).of(0.25);
  }
}