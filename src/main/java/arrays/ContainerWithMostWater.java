package arrays;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
  // area = (end - start) * min(height(end), height(start))
  public int maxArea(int[] height) {
    int max = 0;
    int start = 0;
    int end = height.length - 1;
    while (start < end) {
      max = Math.max(max, (end - start) * Math.min(height[end], height[start]));
      if (height[end] > height[start]) {
        start++;
      } else {
        end--;
      }
    }
    return max;
  }
}
