package stacks;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example: https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
  public static int trap(int[] height) {
    Stack<Integer> st = new Stack<>();
    int sum = 0;

    for (int i = 0; i < height.length; i++) {
      while (!st.empty() && height[st.peek()] < height[i]) {
        int lowerHeight = st.pop();
        if (st.empty()) break;

        // left wall: st.peek()
        // right wall: i
        // base: lowerHeight

        int distance = i - st.peek() - 1;
        int boundedHeight = Math.min(height[st.peek()], height[i]) - height[lowerHeight];
        sum += distance * boundedHeight;
      }
      st.push(i);
    }

    return sum;
  }
}
