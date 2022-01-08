// Author - Vaishakh K
package graphtraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstTraversal implements GraphTraversal{
  @Override
  public void search(Graph graph, int sourceVertex) {
    Queue<Integer> queue = new LinkedList<Integer>();
    Set<Integer> visited = new HashSet<Integer>();

    queue.add(sourceVertex);
    visited.add(sourceVertex);

    while (queue.size() > 0) {
      Integer vertex = queue.poll();
      System.out.format("Vertex %d\n", vertex);
      LinkedList<Integer> adjacentVertices = graph.edges[vertex];
      for (int idx = 0; idx < adjacentVertices.size(); idx++) {
        Integer adjVertex = adjacentVertices.get(idx);
        if (!visited.contains(adjVertex)) {
          queue.add(adjVertex);
          visited.add(adjVertex);
        }
      }
    }
  }

  public static void main (String[] args) {
    BreadthFirstTraversal breadthFirstTraversal = new BreadthFirstTraversal();
    Graph graph = new Graph(5);

    graph.addEdge(0, 0);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(2, 3);
    graph.addEdge(2, 4);
    graph.addEdge(2, 2);
    graph.addEdge(3, 0);
    graph.addEdge(3, 1);

    int sourceVertex = 0;
    System.out.println("Breadth First Traversal:");
    breadthFirstTraversal.search(graph, sourceVertex);
  }
}
