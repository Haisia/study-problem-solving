package org.haisia.p9095;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] problems = new int[T];
    int maxProblem = 3;
    for (int i = 0; i < T; i++) {
      problems[i] = sc.nextInt();
      maxProblem = Math.max(problems[i], maxProblem);
    }

    int[] dp = new int[maxProblem + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= maxProblem && i >= 4; i++) {
      dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < problems.length; i++) {
      sb.append(dp[problems[i]]).append("\n");
    }
    System.out.println(sb);
  }
}
