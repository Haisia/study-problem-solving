package org.haisia.p17626;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    int[] arr = new int[50001];
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 3;

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    if (n == 1) {
      System.out.println(arr[1]);
      return;
    }
    if (n == 2) {
      System.out.println(arr[2]);
      return;
    }
    if (n == 3) {
      System.out.println(arr[3]);
      return;
    }

    int i = 2;

    List<Integer> squares = new ArrayList<>();
    squares.add(1);
    while (i * i <= n) {
      arr[i * i] = 1;
      squares.add(i*i);
      i++;
    }

    for (int j = 1; j <= n; j++) {
      int target = j;
      arr[j] = squares.stream().mapToInt(v -> {
        if (v > target) return Integer.MAX_VALUE;
        return arr[target - v] + 1;
      }).min().getAsInt();
    }
    System.out.println(arr[n]);
  }
}
