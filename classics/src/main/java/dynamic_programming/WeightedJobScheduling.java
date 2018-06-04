package dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given N jobs where every job is represented by following three elements of it.
 *
 * Start Time
 * Finish Time
 * Profit or Value Associated
 * Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 */

class Job {
  final int start;
  final int finish;
  final int profit;

  public Job(int start, int finish, int profit) {
    this.start = start;
    this.finish = finish;
    this.profit = profit;
  }
}

public class WeightedJobScheduling {
  /**
   * Input: Number of Jobs n = 4
   *        Job Details {Start Time, Finish Time, Profit}
   *        Job 1:  {1, 2, 50}
   *        Job 2:  {3, 5, 20}
   *        Job 3:  {6, 19, 100}
   *        Job 4:  {2, 100, 200}
   * Output: The maximum profit is 250.
   * We can get the maximum profit by scheduling jobs 1 and 4.
   * Note that there is longer schedules possible Jobs 1, 2 and 3
   * but the profit with this schedule is 20+50+100 which is less than 250.
   */
  public static int maximumProfit(Job[] jobs) {
    if (jobs.length == 0) return 0;

    Arrays.sort(jobs, Comparator.comparingInt(o -> o.finish));
    int[] profits = new int[jobs.length];
    profits[0] = jobs[0].profit;

    for (int curr = 1; curr < jobs.length; curr++) {
      int currProfit = jobs[curr].profit;
      int latestNonConflict = latestNonConflict(jobs, curr);
      if (latestNonConflict != -1) currProfit += profits[latestNonConflict];
      profits[curr] = Math.max(currProfit, profits[curr - 1]);
    }

    return profits[jobs.length - 1];
  }

  private static int latestNonConflict(Job[] arr, int curr) {
    for (int prev = curr - 1; prev >= 0; prev --) {
      if (arr[prev].finish <= arr[curr].start) return prev;
    }
    return -1;
  }
}
