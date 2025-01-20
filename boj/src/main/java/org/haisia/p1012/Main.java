package org.haisia.p1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int M = sc.nextInt();
      int N = sc.nextInt();
      int K = sc.nextInt();

      boolean[][] board = new boolean[N][M];
      boolean[][] visited = new boolean[N][M];
      for (int j = 0; j < K; j++) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        board[Y][X] = true;
      }

      int result = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (board[j][k] && !visited[j][k]) {
            result++;
            bfs(board, visited, j, k, N, M);
          }
        }
      }
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

  static void bfs(boolean[][] board, boolean[][] visited, int x, int y, int N, int M) {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{x, y});
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      for (int[] dir : directions) {
        int nx = curr[0] + dir[0];
        int ny = curr[1] + dir[1];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[nx][ny] && !visited[nx][ny]) {
          q.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
        }
      }
    }
  }
}
