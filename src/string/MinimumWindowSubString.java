// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/minimum-window-substring/
package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubString {
  public static void main(String[] args) {
    String s = "adobecodebanc";
    String t = "abc";
    System.out.println(minWindow(s, t));
  }

  public static boolean isValid(String str, Map<Character, Integer> countMap) {
    Map<Character, Integer> sCountMap = new HashMap<>();
    for (char c: str.toCharArray()) {
      sCountMap.put(c, sCountMap.getOrDefault(c, 0) + 1);
    }

    for (char c: countMap.keySet()) {
      if (countMap.get(c) > sCountMap.getOrDefault(c, 0)) {
        return false;
      }
    }
    return true;

  }

  public static String minWindow(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();

    if (tLen > sLen) {
      return "";
    }

    String minWindowString = "";

    Map<Character, Integer> countMap = new HashMap<>();
    List<Integer> startIdx = new ArrayList<>();
    for (char c: t.toCharArray()) {
      countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < sLen; i++) {
      if (countMap.containsKey(s.charAt(i))) {
        startIdx.add(i);
      }
    }

    if (startIdx.size() == 0) {
      return "";
    }

    int start = 0;
    int end = startIdx.get(0);

    while (end < sLen && start < startIdx.size()) {
      String str = s.substring(startIdx.get(start), end + 1);
      if (isValid(str, countMap)) {
        if (minWindowString.equals("") || minWindowString.length() > str.length()) {
          minWindowString = str;
        }
        start++;
      } else {
        end = Math.max(end + 1, start + 1);
      }
    }

    return minWindowString;
  }

}
