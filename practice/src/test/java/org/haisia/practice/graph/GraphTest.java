package org.haisia.practice.graph;

import org.haisia.practice.graph.answer.AGraph;
import org.haisia.practice.graph.question.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

  private IGraph<String> graph;

  @BeforeEach
  void setUp() {
    graph = new AGraph<>();
  }

  @Test
  void testAddVertexAndContainsVertex() {
    // 정점 추가
    graph.addVertex("A");
    graph.addVertex("B");

    // 정점 존재 확인 테스트
    assertTrue(graph.containsVertex("A"), "정점 A는 그래프에 있어야 합니다.");
    assertTrue(graph.containsVertex("B"), "정점 B는 그래프에 있어야 합니다.");
    assertFalse(graph.containsVertex("C"), "정점 C는 그래프에 없어야 합니다.");
  }

  @Test
  void testAddEdgeAndContainsEdge() {
    // 정점 및 간선 추가
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addEdge("A", "B");

    // 간선 존재 확인 테스트
    assertTrue(graph.containsEdge("A", "B"), "간선 A-B는 그래프에 있어야 합니다.");
    assertTrue(graph.containsEdge("B", "A"), "무방향 그래프에서 간선 B-A도 존재해야 합니다.");
    assertFalse(graph.containsEdge("A", "C"), "A와 C 사이의 간선은 존재하지 않아야 합니다.");
  }

  @Test
  void testGetAdjacentVertices() {
    // 정점 및 간선 추가
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");

    // 특정 정점의 인접 리스트 확인
    List<String> adjacentVertices = graph.getAdjacentVertices("A");
    assertNotNull(adjacentVertices, "정점 A에 인접한 리스트는 null이 아니어야 합니다.");
    assertTrue(adjacentVertices.contains("B"), "정점 A에 인접한 정점 리스트에는 B가 포함되어야 합니다.");
    assertTrue(adjacentVertices.contains("C"), "정점 A에 인접한 정점 리스트에는 C가 포함되어야 합니다.");
    assertFalse(adjacentVertices.contains("D"), "정점 A에 인접한 정점 리스트에는 D가 포함되면 안 됩니다.");
  }

  @Test
  void testPrintGraph() {
    // 정점 및 간선 추가
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addEdge("A", "B");

    // 그래프 출력 (출력값은 수동으로 확인하므로 테스트에 포함되지 않음)
    System.out.println("그래프 상태:");
    graph.printGraph();
  }
}