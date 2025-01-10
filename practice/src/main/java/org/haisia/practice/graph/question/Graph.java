package org.haisia.practice.graph.question;

import java.util.List;

public class Graph<T> implements org.haisia.practice.graph.IGraph<T> {
  @Override
  public void addVertex(T vertex) {

  }

  @Override
  public void addEdge(T vertex1, T vertex2) {

  }

  @Override
  public List<T> getAdjacentVertices(T vertex) {
    return List.of();
  }

  @Override
  public boolean containsVertex(T vertex) {
    return false;
  }

  @Override
  public boolean containsEdge(T vertex1, T vertex2) {
    return false;
  }

  @Override
  public void printGraph() {

  }
}
