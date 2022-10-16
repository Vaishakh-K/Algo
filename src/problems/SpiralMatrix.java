package problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
     int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    int[][] matrix = new int[][]{{6, 7, 8}};
    List<Integer> spiralList = printSpiralMatrix(matrix);
    for (Integer item: spiralList) {
      System.out.format("%d ", item);
    }
  }

  public static List<Integer> printSpiralMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    List<Integer> spiralList = new ArrayList<Integer>();

    if (rows == 1) {
      for (int c = 0; c < cols; c++) {
        spiralList.add(matrix[0][c]);
      }
      return spiralList;
    }

    if (cols == 1) {
      for (int r = 0; r < rows; r++) {
        spiralList.add(matrix[r][0]);
      }
      return spiralList;
    }

    int startRow = 0;
    int endRow = rows - 1;
    int startCol = 0;
    int endCol = cols - 1;

    while (startRow <= endRow && startCol <= endCol) {
      for (int c = startCol; c <= endCol; c++) {
        spiralList.add(matrix[startRow][c]);
      }

      for (int r = startRow + 1; r <= endRow; r++) {
        spiralList.add(matrix[r][endCol]);
      }

      if (startRow != endRow) {
        for (int c = endCol - 1; c >= startCol; c--) {
          spiralList.add(matrix[endRow][c]);
        }
      }

      if (startCol != endCol) {
        for (int r = endRow - 1; r > startRow; r--) {
          spiralList.add(matrix[r][startCol]);
        }
      }

      startRow++;
      endRow--;
      startCol++;
      endCol--;
    }

    return spiralList;
  }
}
