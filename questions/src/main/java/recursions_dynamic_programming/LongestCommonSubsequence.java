package recursions_dynamic_programming;

public class LongestCommonSubsequence {
  public static int[] longestCommonSubsequence(int[] a, int[] b) {
    if (a.length == 0) return a;
    if (b.length == 0) return b;
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
