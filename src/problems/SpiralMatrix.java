package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    int startRow = 0;
    int endRow = rows - 1;
    int startCol = 0;
    int endCol = cols - 1;

    while (startRow <= endRow && startCol <= endCol) {
      // Totally 4 movements.

      // Left to Right.
      for (int c = startCol; c <= endCol; c++) {
        spiralList.add(matrix[startRow][c]);
      }

      // Top to Bottom.
      for (int r = startRow + 1; r <= endRow; r++) {
        spiralList.add(matrix[r][endCol]);
      }

      // Right to Left. Only if not the same row covered when moving left to right.
      if (startRow != endRow) {
        for (int c = endCol - 1; c >= startCol; c--) {
          spiralList.add(matrix[endRow][c]);
        }
      }

      // Bottom to Top. Only if not the same column covered when moving top to bottom.
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
