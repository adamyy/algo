package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This is a follow up of Shortest Word Distance.
 *
 * The only difference is now you are given the list of words
 * and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 *
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and
 * return the shortest distance between these two words in the list.
 *
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistanceII {
  private final String[] words;

  /**
   * indices are sorted in ascending order
   */
  private final HashMap<String, List<Integer>> indexMap = new HashMap<>();

  public ShortestWordDistanceII(String[] words) {
    this.words = words;
    for (int i = 0; i < words.length; i++) {
      if (!indexMap.containsKey(words[i])) indexMap.put(words[i], new LinkedList<>());
      List<Integer> indices = indexMap.get(words[i]);
      indices.add(i);
    }
  }

  public int shortestDistance(String first, String second) {
    List<Integer> firstList = indexMap.get(first);
    List<Integer> secondList = indexMap.get(second);
    int firstListSize = firstList.size(), firstListIndex = 0;
    int secondListSize = secondList.size(), secondListIndex = 0;
    int result = words.length - 1;
    while (firstListIndex < firstListSize && secondListIndex < secondListSize) {
      result = Math.min(result, Math.abs(firstList.get(firstListIndex) - secondList.get(secondListIndex)));
      if (firstList.get(firstListIndex) < secondList.get(secondListIndex)) {
        firstListIndex++;
      } else {
        secondListIndex++;
      }
    }
    return result;
  }
}
