package arrays;

/**
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {

  public int[] nextPermutation(int[] nums) {
    int[] result = nums.clone();
    if (result.length <= 1) return result;

    int index = result.length - 1;

    while(index > 0) {
      if(result[index - 1] < result[index]) break;
      index--;
    }

    if (index == 0) {
      reverseSort(result, 0, result.length - 1);
    } else {
      int target = result[index - 1];
      int searchIndex = result.length - 1;
      while(searchIndex >= index) { // from last to current
        if (result[searchIndex] > target) break;
        searchIndex--;
      }
      swap(result, searchIndex, index - 1);
      reverseSort(result, index, result.length - 1);
    }

    return result;
  }

  public void nextPermutations(int[] nums) {
    if (nums.length <= 1) return;

    int index = nums.length - 1;

    while(index > 0) {
      if(nums[index - 1] < nums[index]) break;
      index--;
    }

    if (index == 0) {
      reverseSort(nums, 0, nums.length - 1);
    } else {
      int target = nums[index - 1];
      int searchIndex = nums.length - 1;
      while(searchIndex >= index) { // from last to current
        if (nums[searchIndex] > target) break;
        searchIndex--;
      }
      swap(nums, searchIndex, index - 1);
      reverseSort(nums, index, nums.length - 1);
    }
  }

  private void reverseSort(int[] nums, int start, int end) {
    if (start > end) return;
    for(int i = start; i <= (end + start)/2; i++) swap(nums, i, start + end - i);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
