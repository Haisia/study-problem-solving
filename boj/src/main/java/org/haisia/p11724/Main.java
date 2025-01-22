package org.haisia.p11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    boolean[][] map = new boolean[N+1][N+1];
    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      map[u][v] = true;
      map[v][u] = true;
    }

    boolean[] visited = new boolean[N+1];
    int result = 0;
    for (int i = 1; i <= N; i++) {
      if (visited[i]) continue;

      result++;
      Queue<Integer> q = new LinkedList<>();
      q.offer(i);
      while (!q.isEmpty()) {
        Integer target = q.poll();
        visited[target] = true;
        for (int j = 1; j <= N; j++) {
          if (map[target][j] && !visited[j]) {
            visited[j] = true;
            q.offer(j);
          }
        }
      }
    }
    System.out.println(result);
  }
}
