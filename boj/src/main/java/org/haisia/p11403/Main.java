package org.haisia.p11403;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    int[][] result = new int[N][N];
    for (int i = 0; i < N; i++) {
      Queue<Integer> q = new LinkedList<>();
      boolean[][] visited = new boolean[N][N];
      q.offer(i);
      while (!q.isEmpty()) {
        Integer target = q.poll();
        for (int j = 0; j < N; j++) {
          if (!visited[target][j] && board[target][j] == 1) {
            visited[target][j] = true;
            result[i][j] = 1;
            q.offer(j);
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
