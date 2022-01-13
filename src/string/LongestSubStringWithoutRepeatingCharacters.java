// Author - Vaishakh K
package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
  public static void main (String[] args) {
    String str = "abcapiqeccannxwertyuhjg";
    int len = lengthOfLongestSubstring(str);
    System.out.format("Length of longest substring without repeating chars = %d", len);
  }

  public static int lengthOfLongestSubstring(String s) {
    int sLen = s.length();
    int start = 0;
    int maxLen = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();


    for (int end = 0; end < sLen; end++) {
      char charAtEnd = s.charAt(end);

      if (map.containsKey(charAtEnd)) {
        start  = Math.max(start, map.get(charAtEnd) + 1);
      }

      maxLen = Math.max(maxLen, end - start + 1);
      map.put(charAtEnd, end);
    }

    return maxLen;

  }
}
