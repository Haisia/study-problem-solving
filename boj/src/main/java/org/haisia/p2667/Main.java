package org.haisia.p2667;

import java.util.*;

class Main {
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    map = new int[N][N];
    List<Integer> results = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < line.length(); j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    visited = new boolean[N][N];

    // 동서남북
    int[] dn = {0, 0, 1, -1};
    int[] dm = {1, -1, 0, 0};

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (isValid(i, j)) {
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[]{i, j});
          visited[i][j] = true;
          int result = 1;
          while (!q.isEmpty()) {
            int[] target = q.poll();

            for (int k = 0; k < 4; k++) {
              int n = target[0] + dn[k];
              int m = target[1] + dm[k];

              if (isValid(n, m)) {
                q.offer(new int[]{n, m});
                visited[n][m] = true;
                result++;
              }
            }
          }
          results.add(result);
        }
      }
    }
    results.sort((a, b) -> a - b);
    StringBuilder sb = new StringBuilder();
    sb.append(results.size()).append("\n");
    for (Integer result : results) {
      sb.append(result).append("\n");
    }
    System.out.println(sb);

  }

  static boolean isValid(int n, int m) {
    if (n < 0) return false;
    if (n >= map.length) return false;
    if (m < 0) return false;
    if (m >= map[0].length) return false;
    if (visited[n][m]) return false;
    if (map[n][m] == 0) return false;
    return true;
  }
}
