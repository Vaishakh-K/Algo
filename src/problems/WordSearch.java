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

  public static boolean hasWord(char[][] board, String word, int[][] visited, StringBuilder sb, int r, int c) {
    if (!isValidIndex(board.length, board[0].length, r, c, visited)) {
      return false;
    }
    visited[r][c] = 1;
    sb.append(board[r][c]);

    if (sb.toString().length() > word.length()) {
      visited[r][c] = 0;
      sb.deleteCharAt(sb.length() - 1);
      return false;
    }

    if (sb.toString().compareTo(word) == 0) {
      return true;
    }

    int sbLen = sb.toString().length();
    if (sb.toString().compareTo(word.substring(0, sbLen)) != 0) {
      visited[r][c] = 0;
      sb.deleteCharAt(sb.length() - 1);
      return false;
    }

    boolean result = false;
    for (int i = 0; i < 4; i++) {
      result = result || hasWord(board, word, visited, sb, r + directions[i][0], c + directions[i][1]);
    }

    visited[r][c] = 0;
    sb.deleteCharAt(sb.length() - 1);
    return result;

  }

  public static boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (board[r][c] == word.charAt(0)) {
          StringBuilder sb = new StringBuilder();
          int[][] visited = new int[rows][cols];
          if (hasWord(board, word, visited, sb, r, c)) {
            return true;
          }
        }
      }
    }

    return false;
  }
}
