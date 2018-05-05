package strings;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class OneAwayTest {

  @Test
  public void oneAway() {
    // one away
    assertThat(OneAway.oneAway("pale", "pale")).isTrue();
    assertThat(OneAway.oneAway("pale", "ple")).isTrue();
    assertThat(OneAway.oneAway("pale", "pales")).isTrue();
    assertThat(OneAway.oneAway("pale", "bale")).isTrue();

    // two away
    assertThat(OneAway.oneAway("pale", "bake")).isFalse();
    assertThat(OneAway.oneAway("pale", "apales")).isFalse();
  }
}