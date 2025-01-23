package org.haisia.p1389;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] arr = new int[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      arr[u][v] = 1;
      arr[v][u] = 1;
    }

    for (int moveCount = 2; moveCount <= N; moveCount++) {
      for (int i = 1; i <= N; i++) {
        // 만약 i = 1, moveCount = 2 이면,
        // 1번이 2번만에 갈수있는 곳을 구하여 arr에 체운는 로직

        Queue<Integer> q = new LinkedList<>();
        for (int j = 1; j < arr[i].length; j++) {
          if (arr[i][j] == moveCount - 1) q.offer(j);
        }
        // q 와 인접한곳을 moveCount 와 기존값중 작은걸로 체운다 기본값 0 주의

        while (!q.isEmpty()) {
          Integer target = q.poll();
          for (int j = 1; j < arr[target].length; j++) {
            if (i == j) continue;
            if (arr[target][j] == 1) {
              if (arr[i][j] == 0) {
                arr[i][j] = moveCount;
                arr[j][i] = arr[i][j];
              } else {
                arr[i][j] = Math.min(arr[i][j], moveCount);
                arr[j][i] = arr[i][j];
              }
            }
          }
        }
      }
    }

    int minSum = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 1; i < arr.length; i++) {
      int sum = Arrays.stream(arr[i]).sum();
      if (sum < minSum) {
        minSum = sum;
        result = i;
      }
    }

    System.out.println(result);
  }
}
