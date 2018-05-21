package arrays;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = "coding", word2 = "practice", return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 *
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceI {
  public static int shortestWordDistanceI(String[] words, String first, String second) {
    int min = Integer.MAX_VALUE;
    int firstIndex = -1;
    int secondIndex = -1;

    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(first)) firstIndex = i;
      if (words[i].equals(second)) secondIndex = i;
      if (firstIndex != -1 && secondIndex != -1) min = Math.min(min, Math.abs(secondIndex - firstIndex));
    }

    return min;
  }
}
