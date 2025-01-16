package org.haisia.p11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    for (int i = 1; i <= N; i++) {
      q.offer(i);
    }

    StringBuilder sb = new StringBuilder().append("<");
    while (!q.isEmpty()) {
      for (int i = 0; i < K - 1; i++) {
        q.offer(q.poll());
      }
      sb.append(q.poll()).append(", ");
    }
    String substring = sb.substring(0, sb.length() - 2);
    System.out.println(substring+">");
  }

}
