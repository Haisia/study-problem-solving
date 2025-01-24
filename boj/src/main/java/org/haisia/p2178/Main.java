package org.haisia.p2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    map = new int[N][M];
    visited = new boolean[N][M];
    int[][] cost = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < line.length(); j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    // {n, m}
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0,0});
    visited[0][0] = true;

    // 동서남북
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    while (!q.isEmpty()) {
      int[] target = q.poll();

      for (int i = 0; i < 4; i++) {
        int n = target[0] + dy[i];
        int m = target[1] + dx[i];
        if (checkValid(n, m)) {
          visited[n][m] = true;
          cost[n][m] = cost[target[0]][target[1]] + 1;

          if (n == N - 1 && m == M - 1) {
            System.out.println(cost[n][m] + 1);
            return;
          }
          q.offer(new int[]{n, m});
        }
      }
    }
  }

  static boolean checkValid(int n, int m) {
    if (n < 0) return false;
    if (n >= map.length) return false;
    if (m < 0) return false;
    if (m >= map[0].length) return false;
    if (visited[n][m]) return false;
    if (map[n][m] == 0) return false;
    return true;
  }
}
