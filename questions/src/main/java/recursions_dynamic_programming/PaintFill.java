package recursions_dynamic_programming;

/**
 * Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
 * That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
 * fill in the surrounding area until the color changes from the original color.
 */
public class PaintFill {
  enum Color {
    Black, White, Red, Yellow, Green
  }

  public static boolean paintFill(Color[][] screen, int r, int c, Color target) {
    if (screen[r][c] == target) return false;
    return paintFill(screen, r, c, screen[r][c], target);
  }

  private static boolean paintFill(Color[][] screen, int r, int c, Color previous, Color target) {
    if (!validIndex(screen, r, c)) return false;

    if (screen[r][c] == previous) {
      screen[r][c] = target;
      paintFill(screen, r + 1, c, previous, target);
      paintFill(screen, r - 1, c, previous, target);
      paintFill(screen, r, c + 1, previous, target);
      paintFill(screen, r, c - 1, previous, target);
    }

    return true;
  }

  private static boolean validIndex(Color[][] screen, int r, int c) {
    return r >= 0 && r < screen.length && c >= 0 && c < screen[0].length;
  }
}
