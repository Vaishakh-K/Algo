// Author - Vaishakh K
package string;

public class LongestCommonSubstring {
  public static void main (String[] args) {
    String str1 = "abcdefghijklmnop";
    String str2 = "acdefbdfujklngjlmnop";
    int len = getLongestCommonSubstring(str1, str2);
    System.out.format("Length of the longest common substring = %d", len);
  }

  public static int getLongestCommonSubstring(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();

    if (len1 == 0 || len2 == 0) {
      return 0;
    }

    int[][] maxLenGrid = new int[len1 + 1][len2 + 1];
    int maxLen = 0;

    for (int idx1 = len1 - 1; idx1 >= 0; idx1--) {
      for (int idx2 = len2 - 1; idx2 >= 0; idx2--) {
        if (str1.charAt(idx1) == str2.charAt(idx2)) {
          maxLenGrid[idx1][idx2] = maxLenGrid[idx1 + 1][idx2 + 1] + 1;
        }
        maxLen = Math.max(maxLen, maxLenGrid[idx1][idx2]);
      }
    }

    return maxLen;
  }
}
