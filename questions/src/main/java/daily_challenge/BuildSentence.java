package daily_challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This problem was asked by Microsoft.
 *
 * Given a dictionary of words and a string made up of those words (no spaces),
 * return the original sentence in a list.
 *
 * If there is more than one possible reconstruction, return any of them.
 * If there is no possible reconstruction, then return null.
 *
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 *
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class BuildSentence {
  static class TrieNode {
    char ch;
    String word;
    Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(char ch) {
      this.ch = ch;
    }
  }

  public static List<String> build(List<String> words, String sentence) {
    TrieNode root = new TrieNode('\0');
    for (String word: words) { // build tree
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (node.children.get(ch) == null) {
          node.children.put(ch, new TrieNode(ch));
        }
        node = node.children.get(ch);
      }
      node.word = word;
    }

    LinkedList<String> result = new LinkedList<>();
    backtrack(result, sentence, 0, root);
    return result;
  }

  private static boolean backtrack(LinkedList<String> result, String sentence, int processed, TrieNode trie) {
    if (processed >= sentence.length()) return true;

    TrieNode node = trie;
    int index = processed;
    while (index < sentence.length()) {
      node = node.children.get(sentence.charAt(index));
      if (node == null) break;

      if (node.word != null) {
        result.addLast(node.word);
        if (backtrack(result, sentence, processed + node.word.length(), trie)) {
          return true;
        }
        result.removeLast(); // backtrack
      }

      index++;
    }
    return false;
  }
}
