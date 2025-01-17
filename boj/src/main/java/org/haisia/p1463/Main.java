package org.haisia.p1463;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N + 1];
    arr[1] = 0;

    for (int i = 2; i <= N; i++) {
      int temp = Integer.MAX_VALUE;

      if (i % 3 == 0) {
        temp = Math.min(temp, arr[i / 3] + 1);
      }

      if (i % 2 == 0) {
        temp = Math.min(temp, arr[i / 2] + 1);
      }

      temp = Math.min(temp, arr[i-1] + 1);

      arr[i] = temp;
    }
    System.out.println(arr[N]);
  }
}
