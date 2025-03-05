package org.haisia.p15652;

import java.util.Scanner;

class Main {
  static int N = 0;
  static int M = 0;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    dfs(0, 0, "");
    System.out.println(sb.toString());
  }

  public static void dfs(int value, int depth, String history) {
    if (depth > 0) {
      history += value + " ";
    }

    if (depth == M) {
      sb.append(history.trim()).append("\n");
      return;
    }

    if (value > N) return;
    for (int i = value; i <= N; i++) {
      if (i == 0) continue;
      dfs(i, depth + 1, history);
    }
  }
}
