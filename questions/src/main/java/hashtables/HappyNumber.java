package hashtables;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public static boolean isHappy(int n) {
    Set<Integer> visited = new HashSet<>();
    while (n != 1) {
      int newNum = 0;
      while (n >= 10) {
        newNum += (n % 10) * (n % 10);
        n /= 10;
      }
      newNum += n * n;
      if (visited.contains(newNum)) return false;
      visited.add(newNum);
      n = newNum;
    }
    return true;
  }

  public static boolean isHappyConstantSpace(int n) {
    int slow = n;
    int fast = n;
    while (true) {
      slow = squareSum(slow);
      fast = squareSum(squareSum(fast));
      if (slow == 1 || fast == 1) {
        return true;
      }
      if (slow == fast) {
        return false;
      }
    }
  }

  private static int squareSum(int n) {
    int sum = 0;
    while (n >= 10) {
      int digit = n % 10;
      sum += digit * digit;
      n /= 10;
    }
    return sum + n * n;
  }
}
