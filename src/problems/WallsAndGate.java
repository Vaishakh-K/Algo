// Author - Vaishakh K
// Problem Link: https://leetcode.com/problems/walls-and-gates
package problems;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGate {
  static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static boolean isValid(int rows, int cols, int r, int c, int[][] rooms, int[][] visited) {
    return (r >= 0 && r < rows && c >= 0 && c < cols && visited[r][c] == 0 && rooms[r][c] != -1 && rooms[r][c] != 0);
  }

  public static void main(String[] args) {
    int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    wallsAndGates(rooms);

    for (int[] r : rooms) {
      for (int c: r) {
        System.out.format("%d ", c);
      }
      System.out.println("");
    }
  }

  public static void bfs(int[][] rooms, int r, int c) {
    int rows = rooms.length;
    int cols = rooms[0].length;

    int depth = 0;
    int[][] visited = new int[rows][cols];
    Queue<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[] {-1, -1});
    queue.add(new Integer[] {r, c});

    while (queue.size() > 0) {
      Integer[] cell = queue.poll();

      if (cell[0] == -1 && cell[1] == -1) {
        if (queue.size() > 0) {
          queue.add(new Integer[] {-1, -1});
        }
        depth++;
      } else {
        for (int[] direction: directions) {
          int newR = cell[0] + direction[0];
          int newC = cell[1] + direction[1];
          if (isValid(rows, cols, newR, newC, rooms, visited)) {
            if (rooms[newR][newC] > depth) {
              rooms[newR][newC] = depth;
              queue.add(new Integer[] {newR, newC});
            }
          }
        }
      }
    }
  }

  public static void wallsAndGates(int[][] rooms) {
    int rows = rooms.length;
    int cols = rooms[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (rooms[r][c] == 0) {
          bfs(rooms, r, c);
        }
      }
    }
  }
}
