package org.haisia.p1654;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int K = sc.nextInt();
    int N = sc.nextInt();

    long lt = 1;
    long rt = 0;

    int[] arr = new int[K];
    for (int i = 0; i < K; i++) {
      arr[i] = sc.nextInt();
      rt = Math.max(rt, arr[i]);
    }

    long result = 0;
    while (lt <= rt) {
      long mt = (lt + rt) / 2;
      long count = getCreatableCount(arr, mt);
      if (count < N) {
        rt = mt - 1;
      } else {
        result = mt;
        lt = mt + 1;
      }
    }
    System.out.println(result);
  }

  private static long getCreatableCount(int[] arr, long length) {
    long count = 0;
    for (int i : arr) {
      count += i / length;
    }
    return count;
  }
}