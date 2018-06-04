package graphs;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
  public static int ladderLengthBFS(String begin, String end, List<String> wordList) {
    if (!wordList.contains(end)) return 0;

    Set<String> wordSet = new HashSet<>(wordList);
    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();

    int depth = 1;
    beginSet.add(begin);
    endSet.add(end);

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }

      Set<String> next = new HashSet<>();
      for (String word: beginSet) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            char old = arr[i];
            arr[i] = c;
            String target = String.valueOf(arr);
            if (endSet.contains(target)) return depth + 1;
            if (!visited.contains(target) && wordSet.contains(target)) {
              next.add(target);
              visited.add(target);
            }
            arr[i] = old; // backtrack
          }
        }
      }

      beginSet = next;
      depth++;
    }

    return 0;
  }

  public static int ladderLengthDijkstra(String begin, String end, List<String> wordList) {
    if (!wordList.contains(end)) return 0;
    HashSet<String> visited = new HashSet<>();
    // populate edges
    HashMap<String, List<String>> edges = new HashMap<>();
    for (String word: wordList) edges.put(word, new LinkedList<>());
    edges.put(begin, new LinkedList<>());

    for (String word: wordList) {
      if (oneEditAway(begin, word)) {
        edges.get(begin).add(word);
        edges.get(word).add(begin);
      }
    }
    for (int i = 0; i < wordList.size(); i++) {
      String curr = wordList.get(i);
      for (int j = i + 1; j < wordList.size(); j++) {
        String other = wordList.get(j);
        if (oneEditAway(curr, other)) {
          edges.get(other).add(curr);
          edges.get(curr).add(other);
        }
      }
    }

    HashMap<String, Integer> wordDistance = new HashMap<>();
    for (String word: wordList) wordDistance.put(word, Integer.MAX_VALUE);
    wordDistance.put(begin, 1);

    PriorityQueue<WordDistancePair> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(new WordDistancePair(begin, 1));

    while (!priorityQueue.isEmpty()) {
      WordDistancePair pair = priorityQueue.poll();
      visited.add(pair.word);
      if (pair.word.equals(end)) break;
      if (edges.get(pair.word) == null) continue;
      int newDistance = pair.distance + 1;
      for (String word: edges.get(pair.word)) {
        if (visited.contains(word)) continue;
        if (wordDistance.get(word) > newDistance) {
          wordDistance.put(word, newDistance);
          priorityQueue.offer(new WordDistancePair(word, newDistance));
        }
      }
    }

    if (wordDistance.get(end) == Integer.MAX_VALUE) return 0;
    return wordDistance.get(end);
  }

  static class WordDistancePair implements Comparable<WordDistancePair> {
    final String word;
    final int distance;

    public WordDistancePair(String word, int distance) {
      this.word = word;
      this.distance = distance;
    }

    @Override
    public String toString() {
      return word + distance;
    }

    @Override
    public int compareTo(WordDistancePair o) {
      return Integer.compare(this.distance, o.distance);
    }
  }

  private static boolean oneEditAway(String first, String second) {
    boolean foundDifference = false;
    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) == second.charAt(i)) continue;
      if (foundDifference) return false;
      foundDifference = true;
    }
    return foundDifference;
  }
}
