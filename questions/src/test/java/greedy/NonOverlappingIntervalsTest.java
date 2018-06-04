package greedy;

import org.junit.Test;

import static greedy.NonOverlappingIntervals.Interval;
import static com.google.common.truth.Truth.*;

public class NonOverlappingIntervalsTest {

  @Test
  public void eraseOverlapIntervals() {
    assertThat(
        NonOverlappingIntervals.eraseOverlapIntervals(new Interval[]{
            Interval.of(1, 2),
            Interval.of(2, 3),
            Interval.of(3, 4),
            Interval.of(1, 3)
        })
    ).isEqualTo(1);

    assertThat(
        NonOverlappingIntervals.eraseOverlapIntervals(new Interval[]{
            Interval.of(1, 2),
            Interval.of(1, 2),
            Interval.of(1, 2)
        })
    ).isEqualTo(2);

    assertThat(
        NonOverlappingIntervals.eraseOverlapIntervals(new Interval[]{
            Interval.of(1, 2),
            Interval.of(2, 3),
        })
    ).isEqualTo(0);

    assertThat(
        NonOverlappingIntervals.eraseOverlapIntervals(new Interval[]{
            Interval.of(1, 2),
            Interval.of(3, 4),
            Interval.of(2, 3),
        })
    ).isEqualTo(0);
  }
}