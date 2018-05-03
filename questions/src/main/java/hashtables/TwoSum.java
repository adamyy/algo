package hashtables;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (index.containsKey(target - num)) {
        result[0] = index.get(target - num);
        result[1] = i;
        return result;
      }

      index.put(num, i);
    }
    return result;
  }
}
