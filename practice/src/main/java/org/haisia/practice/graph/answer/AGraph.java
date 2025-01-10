package org.haisia.practice.graph.answer;

import org.haisia.practice.graph.IGraph;

import java.util.*;

public class AGraph<T> implements IGraph<T> {

  private final HashMap<T, List<T>> graphMap = new HashMap<>();

  @Override
  public void addVertex(T vertex) {
    if(graphMap.containsKey(vertex)) throw new RuntimeException();
    graphMap.put(vertex, new ArrayList<>());
  }

  @Override
  public void addEdge(T vertex1, T vertex2) {
    if (graphMap.get(vertex1) == null || graphMap.get(vertex2) == null) throw new RuntimeException();

    List<T> paths = getAdjacentVertices(vertex1);
    if (paths.contains(vertex2)) return;
    paths.add(vertex2);
    getAdjacentVertices(vertex2).add(vertex1);
  }

  @Override
  public List<T> getAdjacentVertices(T vertex) {
    return graphMap.get(vertex);
  }

  @Override
  public boolean containsVertex(T vertex) {
    return graphMap.containsKey(vertex);
  }

  @Override
  public boolean containsEdge(T vertex1, T vertex2) {
    return graphMap.get(vertex1).contains(vertex2);
  }

  @Override
  public void printGraph() {
    for (Map.Entry<T, List<T>> entry : graphMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue().toString());
    }
  }
}
