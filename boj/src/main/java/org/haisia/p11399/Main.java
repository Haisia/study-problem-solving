package org.haisia.p11399;

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

    Arrays.sort(arr);
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result += arr[i]*(N-i);
    }
    System.out.println(result);
  }
}
