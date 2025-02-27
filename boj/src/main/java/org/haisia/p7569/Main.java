package org.haisia.p7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int H = sc.nextInt();

    int[][][] box = new int[M][N][H];
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < H; k++) {
          box[i][j][k] = sc.nextInt();
          if (box[i][j][k] == 0) {
            q.offer(new int[]{i,j,k});
          }
        }
      }
    }
    if (q.isEmpty()) {
      System.out.println(0);
      return;
    }

    // 동 서 남 북 상 하
    int[] dx = {1, -1, 0, 0, 0, 0};
    int[] dy = {0, 0, 1, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};


    boolean flag = true;

    int result = 0;
    while (flag) {
      flag = false;
      boolean[][][] visited = new boolean[M][N][H];

      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          for (int k = 0; k < H; k++) {
            if (visited[i][j][k]) continue;
            if (box[i][j][k] == 1) {
              for (int l = 0; l < 6; l++) {
                int nx = i + dx[l];
                int ny = j + dy[l];
                int nz = k + dz[l];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && box[nx][ny][nz] == 0) {
                  box[nx][ny][nz] = 1;
                  flag = true;
                  visited[nx][ny][nz] = true;
                }
              }
            }
          }
        }
      }
      result++;
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < H; k++) {
          if (box[i][j][k] == 0) {
            System.out.println(-1);
            return;
          }
        }
      }
    }
    System.out.println(result);
  }
}
