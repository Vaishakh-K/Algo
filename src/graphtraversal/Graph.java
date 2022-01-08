// Author - Vaishakh K
package graphtraversal;

import java.util.LinkedList;

public class Graph {
  public int vertexCount;
  public LinkedList<Integer>[] edges;

  public Graph(int vertexCount) {
    this.vertexCount = vertexCount;
    this.edges = new LinkedList[vertexCount];

    for (int idx = 0; idx < vertexCount; idx++) {
      this.edges[idx] = new LinkedList<Integer>();
    }
  }

  public void addEdge(int source, int target) {
    this.edges[source].add(target);
  }
}
