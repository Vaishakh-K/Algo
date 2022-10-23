// Author: Vaishakh
// LeetCode Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
package problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {

  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 0, 0, 3, 0};
    int k = 3;

    System.out.format("Number of subarrays %d", getNumSubArrays(array, k));
    System.out.format("\nNumber of subarrays (linear solution) %d", getNumSubArraysLinear(array, k));
  }

  public static int getNumSubArrays(int[] array, int k) {
    int len = array.length;
    int count = 0;

    for (int i = 0; i < len; i++) {
      int sum = array[i];
      if (sum == k) {
        count++;
      }
      for (int j = i + 1; j < len; j++) {
        sum += array[j];
        if (sum == k) {
          count++;
        }
      }
    }

    return count;
  }

  public static int getNumSubArraysLinear(int[] array, int k) {
    int len = array.length;
    if (len == 0) {
      return 0;
    }

    int count = 0;

    // Store the cumulative sum as the key and the count of that cumulative sum as value
    Map<Integer, Integer> sumCountMap = new HashMap<>();
    sumCountMap.put(0, 1);
    int sum = 0;
    for (int element : array) {
      sum += element;
      // If the
      if (sumCountMap.containsKey(sum - k)) {
        count += sumCountMap.get(sum - k);
      }
      sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}
