package org.haisia.p1260;

import java.util.*;

class Main {
  static boolean[][] map;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int V = sc.nextInt();

    map = new boolean[N+1][N+1];

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      map[a][b] = true;
      map[b][a] = true;
    }
    dfs(V, new HashSet<>());
    sb.append("\n");
    bfs(V);
    System.out.println(sb);
  }

  static void dfs(int start, Set<Integer> log) {
    if (log.contains(start)) return;

    sb.append(start).append(" ");
    log.add(start);
    for (int i = 0; i < map[start].length; i++) {
      if (map[start][i]) {
        dfs(i, log);
      }
    }
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);

    Set<Integer> log = new HashSet<>();
    while (!q.isEmpty()) {
      Integer target = q.poll();
      if (log.contains(target)) continue;
      sb.append(target).append(" ");
      log.add(target);
      for (int i = 0; i < map[target].length; i++) {
        if (map[target][i] && !log.contains(i)) {
          q.offer(i);
        }
      }
    }
  }
}
