package arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MediumOfTwoSortedArrays {

  /**
   * To solve this problem, we need to understand "What is the use of median".
   * In statistics, the median is used for dividing a set into two equal length subsets,
   * that one subset is always greater than the other.
   *
   * If we understand the use of median for dividing, we are very close to the answer.
   *
   * If we can ensure:
   *
   * 1) len(left_part) == len(right_part)
   * 2) max(left_part) <= min(right_part)
   *
   * then we divide all elements in {A, B} into two parts with equal length,
   * and one part is always greater than the other.
   * Then median = (max(left_part) + min(right_part))/2.
   */
  public static double findMedianSortedArrays(int[] A, int[] B) {
    //to ensure A's length is smaller than B's so we get O(log(min(len(A), len(B))))
    if (A.length > B.length) return findMedianSortedArrays(B, A);
    int totalCount = A.length + B.length;
    int halfLength = (totalCount + 1) / 2; // when there is 7 elements, half length is 4, not 3
    int min = 0, max = A.length;
    while (min <= max) {
      int aIndex = (min + max) / 2;
      int bIndex = halfLength - aIndex;
      if (aIndex < max && B[bIndex - 1] > A[aIndex]) {
        min = aIndex + 1;
      } else if (aIndex > min && A[aIndex - 1] > B[bIndex]) {
        max = aIndex - 1;
      } else {
        int maxLeft;
        if (aIndex == 0) {
          maxLeft = B[bIndex - 1]; // since A[aIndex - 1] does not exist
        } else if (bIndex == 0) {
          maxLeft = A[aIndex - 1];
        } else {
          maxLeft = Math.max(A[aIndex - 1], B[bIndex - 1]);
        }
        if (totalCount % 2 == 1) return maxLeft;

        int minRight;
        if (aIndex == A.length) {
          minRight = B[bIndex];
        } else if (bIndex == B.length) {
          minRight = A[aIndex];
        } else {
          minRight = Math.min(A[aIndex], B[bIndex]);
        }

        return (maxLeft + minRight) / 2.0;
      }
    }
    return -1;
  }
}
