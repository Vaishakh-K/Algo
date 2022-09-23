package problems;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
  public static void main(String[] args) {
    String paragraph = "Bob.          hIt,,baLl";
    String[] banned = new String[] {"bob", "hit"};

    System.out.println(findMostCommonWord(paragraph, banned));
  }

  public static String findMostCommonWord(String paragraph, String[] banned) {
    paragraph = paragraph.trim().toLowerCase();

    Map<String, Integer> map = new HashMap<String, Integer>();
    StringBuilder strWithoutSymbols = new StringBuilder();

    char prevChar = '&';
    for (Character c: paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        strWithoutSymbols.append(c);
      } else {
        if (c != ' ' || prevChar != ' ') {
          strWithoutSymbols.append(' ');
        }
      }
      prevChar = c;
    }

    String s = strWithoutSymbols.toString();

    String[] strs = s.split(" ");

    int maxCount = 0;
    String maxOccuringString = "";
    for (String str: strs) {
      boolean bannedStr = false;
      for (int i = 0; i < banned.length; i++) {
        if (str.equalsIgnoreCase(banned[i]) || str.isEmpty()) {
          bannedStr = true;
          break;
        }
      }

      if (!bannedStr) {
        int newCount = map.getOrDefault(str, 0) + 1;
        map.put(str, newCount);

        if (newCount > maxCount) {
          maxCount = newCount;
          maxOccuringString = str;
        }
      }
    }

    return maxOccuringString;
  }
}
