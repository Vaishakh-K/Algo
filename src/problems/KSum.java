package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
  public List<List<Integer>> resultList = new ArrayList<>();
  public static void main (String[] args) {
    KSum kSum = new KSum();
    kSum.computeKSum();
  }

  public void computeKSum() {
    int[] array = new int[] {1,0,-1,0,-2,2};
    int target = 0;
    int k = 4;

    ArrayList<Integer> list = new ArrayList<>();
    Arrays.sort(array);
    this.getUniqueListsOfK(array, target, k, 0, list);
    for (List<Integer> result: this.resultList) {
      for (Integer element: result) {
        System.out.format("%d ", element);
      }
      System.out.println("");
    }
  }

  public void getUniqueListsOfK(int[] array, int target, int k, int start, ArrayList<Integer> list) {
    int len = array.length;
    if (k == 2) {
      int left = start;
      int right = len - 1;

      while (left < right) {
        int sum = array[left] + array[right];
        if (sum == target) {
          list.add(array[left]);
          list.add(array[right]);
          this.resultList.add((List<Integer>) list.clone());
          list.remove(list.size() - 1);
          list.remove(list.size() - 1);
          right--;
          do {
            left++;
          } while (left < len && array[left] == array[left - 1]);
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    } else {
      while (start < len) {
        list.add(array[start]);
        this.getUniqueListsOfK(array, target - array[start], k - 1, start + 1, list);
        list.remove(list.size() - 1);
        do {
          start++;
        } while (start < len && array[start] == array[start - 1]);
      }
    }
  }
}