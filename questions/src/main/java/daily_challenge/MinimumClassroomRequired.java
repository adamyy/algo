package daily_challenge;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This problem was asked by Snapchat.
 *
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */
public class MinimumClassroomRequired {
  static class Interval {
    final int start, end;

    public static Interval of(int start, int end) {
      return new Interval(start, end);
    }

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  static class Allocation {
    final int time;
    final boolean allocate;
    public Allocation(int time, boolean allocate) {
      this.time = time;
      this.allocate = allocate;
    }
  }

  public static int schedule(List<Interval> intervals) {
    Stream<Allocation> startTimes = intervals.stream()
        .map(interval -> new Allocation(interval.start, true));
    Stream<Allocation> endTimes = intervals.stream()
        .map(interval -> new Allocation(interval.end, false));
    List<Allocation> all = Stream.concat(startTimes, endTimes)
        .sorted(Comparator.comparingInt(o -> o.time))
        .collect(Collectors.toList());

    int size = 0;
    int max = 0;
    for (Allocation allocation: all) {
      if (allocation.allocate) {
        size++;
        max = Math.max(max, size);
      } else {
        size--;
      }
    }

    return max;
  }
}
