package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static void main (String[] args) {
    int[] nums = new int[] {3, 0, 1, -1, -1, 2, -2, 4, -5};
    List<List<Integer>> tripletsList = getTriplets(nums);

    for (List<Integer> triplet: tripletsList) {
      System.out.format("%d %d %d\n", triplet.get(0), triplet.get(1), triplet.get(2));
    }
  }

  public static List<List<Integer>> getTriplets(int[] nums) {
    int numsLen = nums.length;
    List<List<Integer>> tripletsList = new ArrayList<List<Integer>>();

    Arrays.sort(nums);

    for (int i = 0; i < numsLen - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int left = i + 1;
        int right = numsLen - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          int currLeftVal = nums[left];

          if (sum == 0) {
            List<Integer> triplet = new ArrayList<Integer>();
            triplet.add(nums[i]);
            triplet.add(nums[left]);
            triplet.add(nums[right]);
            tripletsList.add(triplet);
            right--;
            while (left < numsLen && nums[left] == currLeftVal) {
              left++;
            }
          } else if (sum > 0) {
            right--;
          } else {
            left++;
          }
        }
      }
    }
    return tripletsList;
  }
}
