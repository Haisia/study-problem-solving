package org.haisia.p11053;

import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int [] dp = new int[N];
    Arrays.fill(dp, 1);

    int result = 0;
    for (int i = 0; i < dp.length; i++) {
      int value = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) value = Math.max(value, dp[j] + 1);
      }
      dp[i] = Math.max(dp[i], value);
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}
