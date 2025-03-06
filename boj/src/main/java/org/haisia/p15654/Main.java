package org.haisia.p15654;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {

  static List<Node> list = new ArrayList<>();
  static int N = 0;
  static int M = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    for (int i = 0; i < N; i++) {
      list.add(new Node(sc.nextInt()));
    }
    list.sort(Comparator.comparingInt(a -> a.value));

    StringBuilder sb = new StringBuilder();
    dfs(0, "", sb);
    System.out.println(sb);
  }

  public static void dfs(int depth, String path, StringBuilder sb) {
    if (depth == M) {
      sb.append(path.trim()).append("\n");
      return;
    }

    for (Node node : list) {
      if (node.used) continue;
      node.used = true;
      dfs(depth + 1, path + node.value + " ", sb);
      node.used = false;
    }
  }

  static class Node {
    int value;
    boolean used;

    public Node(int value) {
      this.value = value;
    }
  }
}
