package org.haisia.p9461;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    /*
     * 1 = 1
     * 2 = 1
     * 3 = 1
     * 4 = [1] + [3] = 2
     * 5 = [4] = 2
     * 6 = [5] + [1]
     * 7 = [6] + [2]
     * 8 = [7] + [3]
     * 9 = [8] + [4]
     * 10 = [9] + [5]
     * 11 = [10] + [6]
     * 12 = [11] + [7]
     * */

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int[] problems = new int[T];

    int maxProblem = 5;
    for (int i = 0; i < T; i++) {
      problems[i] = sc.nextInt();
      maxProblem = Math.max(maxProblem, problems[i]);
    }

    long[] dp = new long[maxProblem + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;

    for (int i = 6; i < dp.length && maxProblem >= 6; i++) {
      dp[i] = dp[i-1] + dp[i-5];
    }

    StringBuilder sb = new StringBuilder();
    for (int problem : problems) {
      sb.append(dp[problem]).append("\n");
    }
    System.out.println(sb);
  }
}
