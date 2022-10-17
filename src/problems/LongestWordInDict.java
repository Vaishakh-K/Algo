package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDict {
  public static void main(String[] args) {
    String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
    System.out.format("Longest String: %s", longestWord(words));
  }

  public static String longestWord(String[] words) {
    int len = words.length;

    Arrays.sort(words);

    int maxLen = 0;
    String longestString = "";
    int start = 0;

    Set<String> stringSet = new HashSet<>();
    int end = 0;
    while(start < len && end < len) {
      if (words[start].length() == 1) {
        stringSet.add(words[start]);
        if (maxLen == 0) {
          longestString = words[start];
          maxLen = 1;
        }
      }
      end = start + 1;

      if (end < len) {
        while(end < len && stringSet.contains(words[end].substring(0, words[end].length() - 1))) {
          if (words[end].length() > maxLen) {
            maxLen = words[end].length();
            longestString = words[end];
          }
          stringSet.add(words[end]);
          end++;
        }
        start = end;
      }
    }

    return longestString;
  }
}
