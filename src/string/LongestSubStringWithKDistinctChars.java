// Author - Vaishakh K
package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars {
  public static void main (String[] args) {
    String s = "cjhjasjvcask";
    int k = 3;
    int len = lengthOfLongestSubstringKDistinct(s, k);
    System.out.format("Length of the longest substring with K distinct characters = %d", len);
  }
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> mapOfCharAndLastLoc = new HashMap<Character, Integer>();
    int len = s.length();

    if (len <= k) {
      return len;
    }

    int start = 0;
    int end = 0;
    int maxLen = 0;
    while (end < len) {
      char c = s.charAt(end);
      mapOfCharAndLastLoc.put(c, end);
      if (mapOfCharAndLastLoc.size() == k + 1) {
        int leastEndLoc = Collections.min(mapOfCharAndLastLoc.values());
        mapOfCharAndLastLoc.remove(s.charAt(leastEndLoc));
        start = leastEndLoc + 1;
      }
      maxLen = Math.max(maxLen, end - start + 1);
      end++;
    }

    return maxLen;
  }
}
