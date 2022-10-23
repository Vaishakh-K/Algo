// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/maximum-product-subarray/
package problems;

public class MaxProductSubArray {
  public static void main(String[] args) {
    int[] array = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    System.out.format("Max product subarray = %d", getMaxProductSubArray(array));
  }

  public static int getMaxProductSubArray(int[] array) {
    int len = array.length;

    if (len == 1) {
      return array[0];
    }

    int maxProduct = array[0];
    int minProduct = array[0];

    int maxValue = array[0];

    for (int i = 1; i < len; i++) {
      int tmpMax = Math.max(array[i], Math.max(maxProduct * array[i], minProduct * array[i]));
      minProduct = Math.min(array[i], Math.min(maxProduct * array[i], minProduct * array[i]));
      maxProduct = tmpMax;

      maxValue = Math.max(maxValue, maxProduct);
    }

    return maxValue;
  }
}
