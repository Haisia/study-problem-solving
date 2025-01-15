package org.haisia.p11651;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int repeat = sc.nextInt();
    List<Node> list = new ArrayList<>();
    for (int i = 0; i < repeat; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      list.add(new Node(x, y));
    }

    list.sort((a, b) -> {
      if (a.y == b.y) return a.x - b.x;
      return a.y - b.y;
    });

    StringBuilder sb = new StringBuilder();
    for (Node node : list) {
      sb.append(node.x).append(" ").append(node.y).append("\n");
    }
    System.out.println(sb);
  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
