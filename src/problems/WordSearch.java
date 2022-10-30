// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/word-search/
package problems;

public class WordSearch {
  static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public static void main(String[] args) {
    char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'},{'B','C', 'D'}};
    String word = "AAB";

    System.out.println(exist(board, word));

  }
  public static boolean isValidIndex(int rows, int cols, int r, int c, int[][] visited) {
    return (r >= 0 && r < rows && c >= 0 && c < cols && visited[r][c] == 0);
  }

  public static boolean hasWord(char[][] board, String word, int[][] visited, int charIdx, int r, int c) {
    if (!isValidIndex(board.length, board[0].length, r, c, visited) || charIdx >= word.length()) {
      return false;
    }

    if (word.charAt(charIdx) != board[r][c]) {
      return  false;
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

  public static boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (board[r][c] == word.charAt(0)) {
          int charIdx = 0;
          int[][] visited = new int[rows][cols];
          if (hasWord(board, word, visited, charIdx, r, c)) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
