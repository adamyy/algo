package stacks;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class TaskSchedulerTest {

  @Test
  public void leastInterval() {
    assertThat(TaskScheduler.leastInterval(new char[] { 'A','A','A','B','B','B' }, 2))
        .isEqualTo(8);
  }
}