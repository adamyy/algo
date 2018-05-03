package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // skip duplicate for target num
      if (i == 0 || nums[i - 1] != nums[i]) {
        int lo = i + 1, hi = nums.length - 1, target = - nums[i];
        while (lo < hi) {
          if (nums[lo] + nums[hi] == target) {
            result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[++lo]);
            while (lo < hi && nums[hi] == nums[--hi]);
          } else if (nums[lo] + nums[hi] < target) {
            ++lo;
          } else {
            --hi;
          }
        }
      }
    }

    return result;
  }
}
