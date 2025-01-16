package org.haisia.p1966;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < repeat; i++) {
      sb.append(findResult(sc)).append("\n");
    }

    System.out.println(sb);
  }

  static int findResult(Scanner sc){
    int countOfData = sc.nextInt();
    int targetOrder = sc.nextInt();

    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < countOfData; i++) {
      q.offer(new Node(sc.nextInt(), i));
    }

    int count = 0;
    while (true) {
      int maxPriority = q.stream().mapToInt(n -> n.priority).max().getAsInt();
      Node node = q.poll();
      if (node.priority == maxPriority) {
        count++;
        if (node.order == targetOrder) return count;
      } else {
        q.offer(node);
      }
    }
  }

  static class Node {
    int priority;
    int order;

    public Node(int priority, int order) {
      this.priority = priority;
      this.order = order;
    }
  }
}
