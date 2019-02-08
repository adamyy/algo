package daily_challenge;

import tags.BinarySearch;
import tags.Trie;

import java.util.*;

/**
 * This problem was asked by Twitter.
 * <p>
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
 * <p>
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * <p>
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */
interface AutoComplete {
  Set<String> query(String prefix);
}

@Trie
class AutoCompleteTrie implements AutoComplete {
  static class TrieNode {
    char ch;
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode(char ch) {
      this.ch = ch;
      this.children = new HashMap<>();
    }
  }

  private final TrieNode root;

  public AutoCompleteTrie(Set<String> words) {
    root = new TrieNode(Character.MIN_VALUE);

    for (String word : words) {
      TrieNode curr = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode next = curr.children.getOrDefault(ch, new TrieNode(ch));
        curr.children.put(ch, next);
        curr = next;
      }
      curr.isWord = true;
    }
  }

  @Trie
  @Override
  public Set<String> query(String prefix) {
    Set<String> set = new HashSet<>();
    TrieNode node = find(prefix);
    if (node == null) return set;
    if (node.isWord) set.add(prefix);
    for (TrieNode child : node.children.values()) {
      dfs(child, new StringBuilder(prefix), set);
    }
    return set;
  }

  private TrieNode find(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode next = curr.children.get(prefix.charAt(i));
      if (next == null) return null;
      curr = next;
    }
    return curr;
  }

  private void dfs(TrieNode node, StringBuilder builder, Set<String> result) {
    builder.append(node.ch);
    if (node.isWord) result.add(builder.toString());
    for (TrieNode child : node.children.values()) {
      dfs(child, builder, result);
    }
    builder.setLength(builder.length() - 1);
  }
}

@BinarySearch
class AutoCompleteBinarySearch implements AutoComplete {
  final List<String> sortedWords;

  public AutoCompleteBinarySearch(Set<String> words) {
    sortedWords = new ArrayList<>(words);
    Collections.sort(sortedWords);
  }

  @Override
  public Set<String> query(String prefix) {
    if (prefix.isEmpty()) return new HashSet<>(sortedWords);
    char lastChar = prefix.charAt(prefix.length() - 1);
    String start = prefix;
    String last = lastChar == 'z' ? prefix + 'a' : prefix.substring(0, prefix.length() - 1) + (char) (lastChar + 1);
    int startIndex = binarySearch(start);
    int lastIndex = binarySearch(last);
    return new HashSet<>(sortedWords.subList(startIndex, lastIndex));
  }

  private int binarySearch(String key) {
    int low = 0;
    int high = sortedWords.size() - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;
      String midVal = sortedWords.get(mid);
      int cmp = midVal.compareTo(key);

      if (cmp < 0) {
        low = mid + 1;
      } else if (cmp > 0) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return low;
  }
}

