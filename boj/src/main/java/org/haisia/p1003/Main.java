package org.haisia.p1003;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] problems = new int[T];
    int maxCase = 1;
    for (int i = 0; i < T; i++) {
      int value = sc.nextInt();
      maxCase = Math.max(value, maxCase);
      problems[i] = value;
    }

    // int[n][0 = 0의 출력수, 1 = 1의 출력수]
    int[][] dp = new int[maxCase + 1][2];
    dp[0][0] = 1;
    dp[0][1] = 0;

    dp[1][0] = 0;
    dp[1][1] = 1;

    if (maxCase >= 2) {
      for (int i = 2; i <= maxCase; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < problems.length; i++) {
      int idx = problems[i];
      sb.append(dp[idx][0]).append(" ").append(dp[idx][1]).append("\n");
    }

    System.out.println(sb);
  }
}
