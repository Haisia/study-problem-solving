package org.haisia.p14940;

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
    int[] start = null;
    int[][] result = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < M; j++) {
        result[i][j] = -1;
        map[i][j] = line.charAt(j * 2) - '0';
        if (map[i][j] == 2) start = new int[]{i, j};
      }
    }

    visited = new boolean[N][M];

    // {n, m}
    Queue<int[]> q = new LinkedList<>();
    q.offer(start);
    result[start[0]][start[1]] = 0;
    visited[start[0]][start[1]] = true;


    // 동서남북
    int[] dn = new int[]{0, 0, 1, -1};
    int[] dm = new int[]{1, -1, 0, 0};
    while (!q.isEmpty()) {
      int[] target = q.poll();
      int cost = result[target[0]][target[1]] + 1;
      for (int i = 0; i < 4; i++) {
        int n = target[0] + dn[i];
        int m = target[1] + dm[i];
        if (isValid(n, m)) {
          if (map[n][m] == 0) {
            result[n][m] = 0;
            visited[n][m] = true;
          } else {
            result[n][m] = cost;
            visited[n][m] = true;
            q.offer(new int[]{n,m});
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) result[i][j] = 0;
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static boolean isValid(int n, int m) {
    if (n < 0) return false;
    if (n >= map.length) return false;
    if (m < 0) return false;
    if (m >= map[0].length) return false;
    if (visited[n][m]) return false;
    return true;
  }
}
