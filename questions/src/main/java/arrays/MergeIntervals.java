package arrays;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
  public static class Interval {
    int start, end;
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Interval interval = (Interval) o;

      if (start != interval.start) return false;
      return end == interval.end;
    }

    @Override
    public int hashCode() {
      int result = start;
      result = 31 * result + end;
      return result;
    }
  }

  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals.isEmpty()) return intervals;

    Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
    List<Interval> result = new ArrayList<>();
    Iterator<Interval> iterator = intervals.iterator();
    Interval curr = iterator.next();
    int currEnd = curr.end;
    while (iterator.hasNext()) {
      Interval next = iterator.next();
      if (next.start > currEnd) {
        result.add(new Interval(curr.start, currEnd));
        curr = next;
        currEnd = curr.end;
      } else {
        currEnd = Math.max(currEnd, next.end);
      }
    }
    result.add(new Interval(curr.start, currEnd));
    return result;
  }
}
