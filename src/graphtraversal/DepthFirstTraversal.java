// Author - Vaishakh K
package graphtraversal;

import java.util.*;

public class DepthFirstTraversal {
  public static void main(String[] args) {
    Map<Character, HashSet<Character>> graph = getGraph();
    Set<Character> visited = new HashSet<Character>();
    ArrayList<Character> dfsTraversed = new ArrayList<Character>();
    printTraversedTree(traverse(graph, dfsTraversed, visited, 'a'));
  }

  public static ArrayList<Character> traverse(Map<Character, HashSet<Character>> graph,
                                              ArrayList<Character> dfsTraversed,
                                              Set<Character> visited,
                                              Character node) {
    dfsTraversed.add(node);
    if (graph.containsKey(node)) {
      for (Character adjNode: graph.get(node)) {
        if (!visited.contains(adjNode)) {
          visited.add(adjNode);
          traverse(graph, dfsTraversed, visited, adjNode);
        }
      }
    }

    return dfsTraversed;
  }

  public static void printTraversedTree(ArrayList<Character> traversedTree) {
    for (Character ch: traversedTree) {
      System.out.format("%c ", ch);
    }
    System.out.println("");
  }

  public static Map<Character, HashSet<Character>> getGraph() {
    Graph graph = new Graph();
    graph.addEdge('a', 'b');
    graph.addEdge('a', 'c');
    graph.addEdge('b', 'd');
    graph.addEdge('c', 'e');
    graph.addEdge('d', 'f');

    return graph.getGraph();
  }

}
