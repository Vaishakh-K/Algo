// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
package problems;

import java.util.PriorityQueue;

public class KthLargestInArray {
  public static void main(String[] args) {
    int[] array = new int[] {4, 7, 1, 9, 3, 0, 10};
    int k = 3;
    System.out.format("(k=%d)th Largest element: %d", k, getKthLargestElement(array, k));
  }

  public static int getKthLargestElement(int[] array, int k) {
    int len = array.length;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->a-b);
    for (int num : array) {
      if (pq.size() < k) {
        pq.add(num);
      } else {
        int topVal = pq.peek();
        if (num > topVal) {
          pq.poll();
          pq.add(num);
        }
      }
    }

    return pq.size() > 0 ? pq.peek() : -1;
  }
}
