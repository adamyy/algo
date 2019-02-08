package daily_challenge;

import java.util.Random;

/**
 * This problem was asked by Facebook.
 *
 * Given a stream of elements too large to store in memory,
 * pick a random element from the stream with uniform probability.
 *
 * Note: this problem only makes sense if you don't know the total number in advance. Otherwise, you would pick a
 * random integer between [0..len[ and record the element corresponding to that index when processed. Setting a seed
 * for the random number generator to avoid random failures due to unlucky distributions of samples.
 *
 * Strategy: assuming that at round n we have already selected between the available samples with uniform
 * probability, accept the incoming one as the new selected sample with a probability that keeps everyone's chances
 * fair. Example: at n==1, the first sample as 100% chance of being selected. n==2, second sample 50% chance, n==3
 * 1/3 chance etc. Proof: for n==5, the prob. of choosing first sample is 1 * 0.5 * 0.666.. * 0.75 * 0.8 = 0.2 = 1/5
 */
interface Stream<T> {
  T next();
  boolean hasNext();
}

public class StreamRandom {
  public static <T> T random(Stream<T> stream) {
    Random random = new Random();
    int sampleCount = 0;
    T selectedSample = null;

    while (stream.hasNext()) {
      T next = stream.next();
      sampleCount++;
      if (random.nextDouble() < 1.0 / sampleCount) {
        selectedSample = next;
      }
    }
    return selectedSample;
  }
}
