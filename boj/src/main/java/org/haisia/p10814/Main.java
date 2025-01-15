package org.haisia.p10814;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<Node> list = new ArrayList<>();
    int repeat = sc.nextInt();
    for (int i = 0; i < repeat; i++) {
      int age = sc.nextInt();
      String name = sc.next();
      list.add(new Node(i, age, name));
    }

    list.sort((a,b) -> {
      if (a.age == b.age) return a.order - b.order;
      return a.age - b.age;
    });

    StringBuilder sb = new StringBuilder();
    for (Node node : list) {
      sb.append(node.age).append(" ").append(node.name).append("\n");
    }
    System.out.println(sb);
  }

  static class Node {
    int order;
    int age;
    String name;

    public Node(int order, int age, String name) {
      this.order = order;
      this.age = age;
      this.name = name;
    }
  }
}
