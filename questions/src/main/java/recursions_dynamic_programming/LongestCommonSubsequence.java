package recursions_dynamic_programming;

public class LongestCommonSubsequence {

  /**
   * Given two sequences, find the length of longest subsequence present in both of them. A
   * subsequence is a sequence that appears in the same relative order, but not necessarily
   * contiguous.
   *
   * Critical observation: L(x, y) = L(x - 1, y - 1) + 1 || L(x - 1, y) || L(x, y - 1)
   */
  public static int longestCommonSubstring(String a, String b) {
    return longestCommonSubstring(a.toCharArray(), a.length(), b.toCharArray(), b.length());
  }

  private static int longestCommonSubstring(char[] a, int aLength, char[] b, int bLength) {
//    // solution: no DP
//    if (aLength == 0 || bLength == 0) {
//      return 0;
//    }
//    if (a[aLength - 1] == b[bLength - 1]) {
//      return 1 + longestCommonSubstring(a, aLength - 1, b, bLength - 1);
//    }
//
//    return Math.max(longestCommonSubstring(a, aLength - 1, b, bLength),
//        longestCommonSubstring(a, aLength, b, bLength - 1));

    int[][] lengths = new int[aLength + 1][bLength + 1];

    for (int i = 0; i <= aLength; i++) {
      for (int j = 0; j <= bLength; j++) {
        if (i == 0 || j == 0) {
          lengths[i][j] = 0;
        } else if (a[i - 1] == b[j - 1]) {
          lengths[i][j] = 1 + lengths[i - 1][j - 1];
        } else {
          lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
        }
      }
    }

    return lengths[aLength][bLength];
  }

  public static int[] longestCommonSubsequence(int[] a, int[] b) {
    if (a.length == 0) {
      return a;
    }
    if (b.length == 0) {
      return b;
    }
    int n = a.length;
    int m = b.length;

    int[][] lengths = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (a[i - 1] == b[j - 1]) {
          lengths[i][j] = 1 + lengths[i - 1][j - 1];
        } else {
          lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
        }
      }
    }

    // reconstruction
    int[] result = new int[lengths[n][m]];
    int index = 0;
    int i = n - 1, j = m - 1;
    while (i >= 0 && j >= 0) {
      if (a[i] == b[j]) {
        result[index++] = a[i];
        i--;
        j--;
      } else if (lengths[i - 1][j] < lengths[i][j - 1]) {
        j--;
      } else {
        i--;
      }
    }

    return result;
  }
}
