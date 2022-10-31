// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
package search;

public class SearchInSortedRotatedArray {
  public static void main(String[] args) {
    int[] array = {4,5,6,7,0,1,2};
    int target = 0;
    System.out.println(searchInArray(array, target));
  }

  public static int searchInArray(int[] array, int target) {
    int len = array.length;

    int low = 0;
    int high = len - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] == target) {
        return mid;
      }

      if (array[low] <= array[mid]) {
        if (target < array[mid] && target >= array[low]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (target <= array[high] && target > array[mid]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }
}
