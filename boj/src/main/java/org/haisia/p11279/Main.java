package org.haisia.p11279;

import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = sc.nextInt();
      if (input == 0) {
        int value = 0;
        if (!pq.isEmpty()) {
          value = pq.poll();
        }
        sb.append(value).append("\n");
      } else {
        pq.offer(input);
      }
    }
    System.out.println(sb);
  }
}
