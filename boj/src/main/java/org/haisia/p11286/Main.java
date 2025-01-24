package org.haisia.p11286;

import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // <{값, 부호(1 or -1)}>
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
      if (a[0] == b[0]) return a[1] - b[1];
      return a[0] - b[0];
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int input = sc.nextInt();

      if (input == 0) {
        int value = 0;
        if (!pq.isEmpty()) {
          int[] target = pq.poll();
          value = target[0] * target[1];
        }
        sb.append(value).append("\n");
      } else {
        if (input > 0) {
          pq.offer(new int[]{input, 1});
        } else {
          pq.offer(new int[]{-input, -1});
        }
      }
    }
    System.out.println(sb);
  }
}
