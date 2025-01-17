package org.haisia.p2579;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    if (N == 1) {
      System.out.println(arr[0]);
      return;
    }

    if (N == 2) {
      System.out.println((arr[0] + arr[1]));
      return;
    }

    // [N번 계단][0 = 직전꺼 밟았을 때, 1 = 직전거 안밟았을 때]
    int[][] dp = new int[N + 1][2];
    dp[1][0] = arr[0];
    dp[1][1] = arr[0];
    dp[2][0] = dp[1][0] + arr[1];
    dp[2][1] = arr[1];

    for (int i = 3; i <= N; i++) {
      dp[i][0] = dp[i-1][1] + arr[i-1];
      dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + arr[i-1];
    }
    System.out.println(Math.max(dp[N][0], dp[N][1]));
  }
}
