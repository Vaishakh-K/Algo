// Author - Vaishakh K
package graphtraversal;

import java.util.*;

public class BreadthFirstTraversal {
  public static void main(String[] args) {
    Map<Character, HashSet<Character>> graph = getGraph();
    printTraversedTree(traverse(graph, 'a'));
  }

  public static ArrayList<Character> traverse(Map<Character, HashSet<Character>> graph, Character root) {
    ArrayList<Character> bfsTraversed = new ArrayList<Character>();
    Queue<Character> queue = new LinkedList<Character>();
    Set<Character> visited = new HashSet<Character>();

    queue.add(root);
    visited.add(root);

    while (!queue.isEmpty()) {
      Character ch = queue.poll();
      bfsTraversed.add(ch);

      if (graph.containsKey(ch)) {
        for (Character adjNode: graph.get(ch)) {
          if (!visited.contains(adjNode)) {
            queue.add(adjNode);
            visited.add(adjNode);
          }
        }
      }
    }

    return bfsTraversed;
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
