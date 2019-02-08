package daily_challenge;

import daily_challenge.MinimumClassroomRequired.Interval;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class MinimumClassroomRequiredTest {

  @Test
  public void schedule() {
    assertThat(MinimumClassroomRequired.schedule(Arrays.asList(Interval.of(30, 75), Interval.of(0, 50), Interval.of(60, 150))))
        .isEqualTo(2);
  }
}