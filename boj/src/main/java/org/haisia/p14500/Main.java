package org.haisia.p14500;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Main {

  static int[][] board = null;
  static boolean[][] visited = null;
  static int N = 0;
  static int M = 0;
  static int result = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();
    board = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        dfs(i, j, 0, new HashSet<>());
      }
    }
    System.out.println(result);
  }

  static void dfs(int i, int j, int sum, Set<Node> nodes) {
    nodes.add(new Node(i,j));
    sum += board[i][j];
    if (nodes.size() == 4) {
      result = Math.max(result, sum);
      return;
    }

    Set<Node> paths = findPath(nodes);
    for (Node path : paths) {
      dfs(path.i, path.j, sum, nodes);
      nodes.remove(new Node(path.i, path.j));
    }
  }

  static Set<Node> findPath(Set<Node> nodes) {
    Set<Node> paths = new HashSet<>();

    // 동 서 남 북
    int[] di = {0, 0, 1, -1};
    int[] dj = {1, -1, 0, 0};

    for (Node node : nodes) {
      for (int k = 0; k < di.length; k++) {
        int _i = node.i + di[k];
        int _j = node.j + dj[k];
        if (!checkPosition(_i, _j)) continue;

        Node newPath = new Node(_i, _j);
        if (nodes.contains(newPath)) continue;
        paths.add(newPath);
      }
    }
    return paths;
  }

  static boolean checkPosition(int i, int j) {
    if (i < 0 || j < 0) return false;
    if (i >= N || j >= M) return false;
    if (visited[i][j]) return false;
    return true;
  }

  static class Node {
    int i;
    int j;

    public Node(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return i == node.i && j == node.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }
}
