// Author - Vaishakh K
package graphtraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DepthFirstTraversal implements GraphTraversal{
  @Override
  public void search(Graph graph, int sourceVertex) {
    Set<Integer> visited = new HashSet<Integer>();
    searchHelper(graph, visited, sourceVertex);
  }

  public void searchHelper(Graph graph, Set<Integer> visited, int vertex) {
    System.out.format("Vertex = %d\n", vertex);
    visited.add(vertex);
    LinkedList<Integer> adjVertices = graph.edges[vertex];
    for (int idx = 0; idx < adjVertices.size(); idx++) {
      Integer adjVertex = adjVertices.get(idx);
      if (!visited.contains(adjVertex)) {
        searchHelper(graph, visited, adjVertex);
      }
    }
  }

  public static void main (String[] args) {
    DepthFirstTraversal depthFirstTraversal = new DepthFirstTraversal();
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
    System.out.println("Depth First Traversal:");
    depthFirstTraversal.search(graph, sourceVertex);
  }

}
