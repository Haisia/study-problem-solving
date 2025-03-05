package org.haisia.p16928;

import java.util.*;

class Main {
  public static void main(String[] args) {
    boolean[] visited = new boolean[101];
    visited[1] = true;
    int[] dp = new int[101];
    final int MAX_DICE_VALUE = 6;

    Queue<Integer> q = new LinkedList<>();
    q.offer(1);

    Map<Integer, Integer> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < N + M; i++) {
      String[] inputs = sc.nextLine().split(" ");
      map.put(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }

    while (!q.isEmpty()) {
      Integer target = q.poll();
      int nextCount = dp[target] + 1;

      for (int i = 1; i <= MAX_DICE_VALUE; i++) {
        int next = target + i;
        if (next > 100) continue;
        if (next == 100) {
          System.out.println(nextCount);
          return;
        }
        if (visited[next]) continue;

        dp[next] = nextCount;
        visited[next] = true;

        if (map.containsKey(next)) {
          Integer move = map.get(next);
          if (visited[move]) continue;
          visited[move] = true;
          dp[move] = nextCount;
          q.offer(move);
        } else {
          q.offer(next);
        }
      }
    }
  }
}
