package org.haisia.p7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

  static int N = 0;
  static int M = 0;
  static int[][] box = null;
  static boolean[][] visited = null;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    M = sc.nextInt();
    N = sc.nextInt();

    box = new int[N][M];
    visited = new boolean[N][M];

    // {0, 1, -1}
    int[] count = new int[3];

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int input = sc.nextInt();
        box[i][j] = input;

        if (input == -1) {
          count[2]++;
        } else if (input == 0) {
          count[0]++;
        } else if (input == 1) {
          count[1]++;
          q.offer(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }

    if (count[0] == 0) {
      System.out.println(0);
      return;
    }

    int result = 0;
    while (!q.isEmpty()) {
      int[] target = q.poll();
      int date = box[target[0]][target[1]] + 1;

      // 동 서 남 북
      int[] di = new int[] {0, 0, 1, -1};
      int[] dj = new int[] {1, -1, 0, 0};

      for (int k = 0; k < di.length; k++) {
        int _i = target[0] + di[k];
        int _j = target[1] + dj[k];

        if (!valid(_i, _j)) continue;
        box[_i][_j] = date;
        visited[_i][_j] = true;
        q.offer(new int[]{_i, _j});
        count[0]--;

        result = Math.max(result, date);
      }
    }

    if (count[0] > 0) {
      System.out.println(-1);
      return;
    }

    System.out.println(result - 1);
  }

  static boolean valid(int i, int j) {
    if (i < 0 || j < 0) return false;
    if (i >= N || j >= M) return false;
    if (visited[i][j]) return false;
    if (box[i][j] == -1) return false;
    return true;
  }
}
