// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/maximum-subarray/
package problems;

public class MaxSumSubArray {
  public static void main(String[] args) {
    int[] array = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    System.out.format("Max sum subarray = %d\n", getMaxSumSubarray(array));
  }

  public static int getMaxSumSubarray(int[] array) {
    int len = array.length;

    if (len == 1) {
      return array[0];
    }

    int maxSum = array[0];
    int currSum = array[0];

    for (int i = 1; i < len; i++) {
      currSum = Math.max(currSum + array[i], array[i]);
      maxSum = Math.max(maxSum, currSum);
    }

    return maxSum;
  }
}
