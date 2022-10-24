package problems;

public class MatrixMultiply {
  public static void main(String[] args) {
    int[][] mat1 = new int[][] {{1, 2, 3}, {4, 0, 5}};
    int[][] mat2 = new int[][] {{1, 0}, {0, 4}, {6, 6}};

    int[][] result = multiply(mat1, mat2);
    for (int[] row: result) {
      for (int v: row) {
        System.out.format("%d ", v);
      }
      System.out.println("");
    }
  }

  public static int[][] multiply(int[][] mat1, int[][] mat2) {
    int m = mat1.length;
    int k = mat1[0].length;
    int n = mat2[0].length;

    int[][] result = new int[m][n];

    for (int mi = 0; mi < m; mi++) {
      for (int ni = 0; ni < n; ni++) {
        int sum = 0;
        for (int ki = 0; ki < k; ki++) {
          sum += mat1[mi][ki] * mat2[ki][ni];
        }
        result[mi][ni] = sum;
      }
    }

    return result;
  }
}
