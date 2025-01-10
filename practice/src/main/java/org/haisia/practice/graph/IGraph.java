package org.haisia.practice.graph;

import java.util.List;

public interface IGraph<T> {

  void addVertex(T vertex);

  void addEdge(T vertex1, T vertex2);

  List<T> getAdjacentVertices(T vertex);

  boolean containsVertex(T vertex);

  boolean containsEdge(T vertex1, T vertex2);

  void printGraph();

}
