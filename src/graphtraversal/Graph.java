// Author - Vaishakh K
package graphtraversal;

import java.util.*;

public class Graph {
  public Map<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();

  public Graph() {}

  public void addEdge(Character src, Character target) {
    HashSet<Character> adjNodes = graph.getOrDefault(src, new HashSet<Character>());
    adjNodes.add(target);
    graph.put(src, adjNodes);
  }

  public Map<Character, HashSet<Character>> getGraph() {
    return graph;
  }
}
