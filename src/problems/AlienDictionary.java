package problems;

import java.util.*;

public class AlienDictionary {
  public static void main(String args[]) {
    String[] alienWords = new String[]{"ac", "ab", "zc", "zb"};//{"wrt", "wrf", "er", "ett", "rftt"};

    System.out.println(alienOrder(alienWords));
  }

  public static String alienOrder(String[] alienWords) {
    StringBuilder order = new StringBuilder();
    int wordsLen = alienWords.length;
    Map<Character, ArrayList<Character>> dictMap = new HashMap<Character, ArrayList<Character>>();
    Map<Character, Integer> countMap = new HashMap<Character, Integer>();

    for (String word : alienWords) {
      for (char ch : word.toCharArray()) {
        countMap.put(ch, 0);
        dictMap.put(ch, new ArrayList<>());
      }
    }

    for (int i = 0; i < wordsLen - 1; i++) {
      int s1Len = alienWords[i].length();
      int s2Len = alienWords[i + 1].length();

      if (s1Len > s2Len && alienWords[i].substring(0, s2Len).equals(alienWords[i + 1].substring(0, s2Len))) {
        return "";
      }

      int compareLen = Math.min(s1Len, s2Len);
      for (int cIdx = 0; cIdx < compareLen; cIdx++) {
        char c1 = alienWords[i].charAt(cIdx);
        char c2 = alienWords[i + 1].charAt(cIdx);
        if (c1 != c2) {
          // Building the graph
          ArrayList<Character> charArr = dictMap.getOrDefault(c1, new ArrayList<Character>());
          charArr.add(c2);
          dictMap.put(c1, charArr);
          // Keeping count for toposort
          countMap.put(c2, countMap.getOrDefault(c2, 0) + 1);

          break;
        }
      }
    }

    Queue<Character> queue = new LinkedList<Character>();

    for (Character ch : countMap.keySet()) {
      if (countMap.get(ch) == 0) {
        queue.add(ch);
      }
    }

    while (!queue.isEmpty()) {
      char ch = queue.poll();
      order.append(ch);
      if (dictMap.containsKey(ch)) {
        for (Character adjNode : dictMap.get(ch)) {
          countMap.put(adjNode, countMap.get(adjNode) - 1);
          if (countMap.get(adjNode) == 0) {
            queue.add(adjNode);
          }
        }
      }
    }

    // Check if invalid
    if (order.toString().length() < countMap.size()) {
      return "";
    }

    return order.toString();
  }
}