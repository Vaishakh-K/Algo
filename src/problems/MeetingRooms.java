// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/meeting-rooms-ii/
package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
  public static void main(String[] args) {
    int[][] meetings = new int[][] {{0, 30}, {5, 15}, {15, 20}};

    System.out.format("Number of meeting rooms needed: %d", getNumMeetingRooms(meetings));
  }

  public static int getNumMeetingRooms(int[][] intervals) {
    Comparator<int[]> comparator = (o1, o2) -> o1[0] - o2[0];

    Arrays.sort(intervals, comparator);

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);

    for (int[] interval: intervals) {
      int startTime = interval[0];
      int endTime = interval[1];

      if (priorityQueue.size() == 0) {
        priorityQueue.add(endTime);
      } else {
        int earliestMeetingEndTime = priorityQueue.peek();
        if (startTime >= earliestMeetingEndTime) {
          priorityQueue.poll();
        }
        priorityQueue.add(endTime);
      }
    }
    return priorityQueue.size();
  }
}
