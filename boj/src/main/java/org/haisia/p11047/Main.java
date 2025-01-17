package org.haisia.p11047;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int result = 0;
    for (int i = N-1; i >= 0; i--) {
      if (K == 0) break;

      if (arr[i] <= K) {
        int d = K / arr[i];
        K -= d*arr[i];
        result += d;
      }
    }
    System.out.println(result);
  }
}
