package daily_challenge;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class LastNOrderIDLogTest {

  @Test
  public void test() {
    LastNOrderIDLog log = new LastNOrderIDLog(10);
    for (int i = 0; i < 20; i++) log.record(i);
    assertThat(log.getLast(1)).isEqualTo(19);
    assertThat(log.getLast(5)).isEqualTo(15);
    log.record(20);
    log.record(21);
    assertThat(log.getLast(1)).isEqualTo(21);
    assertThat(log.getLast(3)).isEqualTo(19);
  }
}