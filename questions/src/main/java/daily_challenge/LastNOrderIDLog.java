package daily_challenge;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 *
 * Implement a data structure to accomplish this, with the following API:
 *    record(order_id): adds the order_id to the log
 *    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 *
 * You should be as efficient with time and space as possible.
 */
public class LastNOrderIDLog {
  private final int[] queue;
  private int queueStart;

  public LastNOrderIDLog(int n) {
    queue = new int[n];
    queueStart = 0;
  }

  public void record(int orderId) {
    queue[queueStart++ % queue.length] = orderId;
  }

  public int getLast(int i) {
    return queue[(queueStart - i) % queue.length];
  }
}
