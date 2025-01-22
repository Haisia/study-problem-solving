package org.haisia.p2805;

import java.util.Scanner;

class Main {

  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    arr = new int[N];
    int maxLength = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      maxLength = Math.max(maxLength, arr[i]);
    }

    int lt = 0;
    int rt = maxLength - 1;
    int result = 0;

    while (lt <= rt) {
      int mt = (lt + rt) / 2;

      long totalCut = cut(mt);

      if (totalCut >= M) {
        result = mt;
        lt = mt + 1;
      } else {
        rt = mt - 1;
      }
    }

    System.out.println(result);
  }

  static long cut(int height) {
    long result = 0;
    for (int tree : arr) {
      if (tree > height) result += tree - height;
    }
    return result;
  }
}