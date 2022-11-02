package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordSearch2 {
  static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public static void main(String[] args) {
    String[] words = {"eat","oath"};
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

    List<String> findWords = findWords(board, words);

    for (String word: findWords) {
      System.out.println(word);
    }
  }

  public static boolean isWordAlreadyFound(String word, List<String> foundWords) {
    for (String foundWord: foundWords) {
      if (foundWord.contains(word)) {
        return true;
      }
    }

    return false;
  }

  public static boolean isValidIndex(int rows, int cols, int r, int c, int[][] visited) {
    return (r >= 0 && r < rows && c >= 0 && c < cols && visited[r][c] == 0);
  }

  public static boolean hasWord(char[][] board, String word, int[][] visited, int charIdx, int r, int c) {
    if (!isValidIndex(board.length, board[0].length, r, c, visited) || charIdx >= word.length()) {
      return false;
    }

    if (word.charAt(charIdx) != board[r][c]) {
      return false;
    }

    if (charIdx == word.length() - 1) {
      return true;
    }

    // The path is valid so far. Hence mark visited and move in 4 directions
    visited[r][c] = 1;
    boolean result = false;
    for (int i = 0; i < 4; i++) {
      result = hasWord(board, word, visited, charIdx + 1, r + directions[i][0], c + directions[i][1]);

      // If one path works then we can stop further processing
      if (result) {
        return true;
      }
    }

    // For backtracking mark the cell is not visited and proceed
    visited[r][c] = 0;
    return result;
  }

  public static boolean findWord(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int[][] visited = new int[rows][cols];
        if (hasWord(board, word, visited, 0, r, c)) {
          return true;
        }
      }
    }
    return false;
  }

  public static List<String> findWords(char[][] board, String[] words) {
    // Sort the words in descending order based on length.
    List<String> foundWords = new ArrayList<String>();
    Comparator<String> comparator = (s1, s2) -> (s2.length() - s1.length());


    for (String word: words) {
      if (isWordAlreadyFound(word, foundWords)) {
        foundWords.add(word);
      } else {
        if (findWord(board, word)) {
          foundWords.add(word);
        }
      }
    }


    return foundWords;
  }
}
