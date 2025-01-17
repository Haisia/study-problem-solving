package org.haisia.p11659;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    long[] sum = new long[N + 1];
    sum[0] = 0;
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i-1] + sc.nextInt();
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();

      sb.append(sum[end] - sum[start-1]).append("\n");
    }
    System.out.println(sb);
  }
}