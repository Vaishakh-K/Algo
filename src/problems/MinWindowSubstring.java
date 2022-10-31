// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/minimum-window-substring/submissions/
package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinWindowSubstring {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindow(s, t));
  }

  public static String minWindow(String s, String t) {
    Map<Character, Integer> tCountMap = new HashMap<>();

    for (char c: t.toCharArray()) {
      tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
    }
    int numCharsToMatch = tCountMap.size();

    int start = 0;
    int end = 0;

    int sLen = s.length();
    int maxLen = Integer.MAX_VALUE;
    String answer = "";
    Map<Character, Integer> compareMap = new HashMap<>();

    int numMatch = 0;
    while (end < sLen) {
      char charAtEnd = s.charAt(end);

      if (tCountMap.containsKey(charAtEnd)) {
        compareMap.put(charAtEnd, compareMap.getOrDefault(charAtEnd, 0) + 1);

        if (Objects.equals(compareMap.get(charAtEnd), tCountMap.get(charAtEnd))) {
          numMatch++;
        }

        int currLen = end - start + 1;

        while (numMatch == numCharsToMatch) {
          if (currLen < maxLen) {
            maxLen = currLen;
            answer = s.substring(start, end + 1);
          }
          char charAtStart = s.charAt(start);
          if (compareMap.containsKey(charAtStart)) {
            compareMap.put(charAtStart, compareMap.get(charAtStart) - 1);
            if (compareMap.get(charAtStart) < tCountMap.get(charAtStart)) {
              numMatch--;
            }
          }
          start++;
          currLen = end - start + 1;
        }
      }
      end++;
    }

    return answer;
  }
}
