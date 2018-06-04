package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * The Naive pattern searching algorithm doesn’t work well in cases
 * where we see many matching characters followed by a mismatching character.
 * Following are some examples.
 *
 *    txt[] = "AAAAAAAAAAAAAAAAAB"
 *    pat[] = "AAAAB"
 *
 *    txt[] = "ABABABCABABABCABABABC"
 *    pat[] =  "ABABAC" (not a worst case, but a bad case for Naive)
 *
 * The KMP matching algorithm uses degenerating property
 * (pattern having same sub-patterns appearing more than once in the pattern)
 * of the pattern and improves the worst case complexity to O(n).
 *
 * The basic idea behind KMP’s algorithm is:
 *    whenever we detect a mismatch (after some matches), we already know some of the characters in the text of next window.
 *    We take advantage of this information to avoid matching the characters that we know will anyway match.
 */
public class KMPPatternMatching {
  public static List<Integer> match(char[] target, char[] pattern) {
    List<Integer> result = new ArrayList<>();
    if (pattern.length == 0 || target.length == 0) return result;
    if (pattern.length > target.length) return result;
    int[] next = buildNextTable(pattern);
    int patternIndex = 0;
    int targetIndex = 0;

    while (targetIndex < target.length) {
      if (patternIndex == -1 || pattern[patternIndex] == target[targetIndex]) {
        patternIndex++;
        targetIndex++;
        if (patternIndex == pattern.length) {
          result.add(targetIndex - pattern.length);
          patternIndex = next[patternIndex - 1];
          targetIndex = targetIndex - pattern.length + 1;
        }
      } else {
        patternIndex = next[patternIndex];
      }
    }

    return result;
  }

  public static int[] buildNextTable(char[] pattern) {
    int[] next = new int[pattern.length];
    next[0] = -1;

    int suffix = 0;
    int prefix = -1;

    while (suffix < pattern.length - 1) {
      if (prefix == -1 || pattern[prefix] == pattern[suffix]) {
        prefix++;
        suffix++;
        next[suffix] = prefix;
      } else {
        prefix = next[prefix];
      }
    }

    return next;
  }
}
