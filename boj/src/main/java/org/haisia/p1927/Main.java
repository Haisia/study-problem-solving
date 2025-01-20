package org.haisia.p1927;

import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int N = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = sc.nextInt();

      if (input == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.offer(input);
      }
    }
    System.out.println(sb);
  }
}
