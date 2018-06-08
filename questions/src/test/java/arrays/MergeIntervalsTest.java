package arrays;

import arrays.MergeIntervals.Interval;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.*;

public class MergeIntervalsTest {

  @Test
  public void merge() {
    assertThat(MergeIntervals.merge(
        Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        )
    )).containsExactly(
        new Interval(1, 6),
        new Interval(8, 10),
        new Interval(15, 18)
    );

    assertThat(MergeIntervals.merge(
        Arrays.asList(
            new Interval(1, 4),
            new Interval(4, 5)
        )
    )).containsExactly(
        new Interval(1, 5)
    );

    assertThat(MergeIntervals.merge(
        Arrays.asList(
            new Interval(1, 4),
            new Interval(0, 4)
        )
    )).containsExactly(
        new Interval(0, 4)
    );

    assertThat(MergeIntervals.merge(
        Arrays.asList(
            new Interval(1, 4),
            new Interval(2, 3)
        )
    )).containsExactly(
        new Interval(1, 4)
    );
  }
}