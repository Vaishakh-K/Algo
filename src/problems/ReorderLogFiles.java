// Author: Vaishakh
// LeetCode Problem Link: https://leetcode.com/problems/reorder-data-in-log-files/
package problems;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
  public static void main(String[] args) {
    String[] logs = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
    String[] reorderedLogs = reorderLogFiles(logs);

    System.out.println("Reordered Logs");
    for (String log: reorderedLogs) {
      System.out.println(log);
    }
  }

  public static String[] reorderLogFiles(String[] logs) {
    int numLogs = logs.length;
    Comparator<String> comparator = (s1, s2) -> {
      // Each String is of the form -> identifier words
      // Letter logs before digit logs
      // Letter logs sorted lexicographically based on their content
      // Digit logs maintain their relative ordering

      String[] s1Split = s1.split(" ", 2);
      String[] s2Split = s2.split(" ", 2);

      char s1WordFirstChar = s1Split[1].charAt(0);
      char s2WordFirstChar = s2Split[1].charAt(0);

      if (Character.isLetter(s1WordFirstChar) && Character.isDigit(s2WordFirstChar)) {
        return -1;
      } else if (Character.isDigit(s1WordFirstChar) && Character.isLetter(s2WordFirstChar)) {
        return 1;
      } else if (Character.isDigit(s1WordFirstChar) && Character.isDigit(s2WordFirstChar)) {
        return 0;
      } else {
        if (s1Split[1].equals(s2Split[1])) {
          return s1Split[0].compareTo(s2Split[0]);
        } else {
          return s1Split[1].compareTo(s2Split[1]);
        }
      }
    };

    Arrays.sort(logs, comparator);
    return logs;
  }
}
