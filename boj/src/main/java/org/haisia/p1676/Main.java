package org.haisia.p1676;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] table = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      int prev = table[i-1];
      int temp = i;
      while (temp % 5 == 0) {
        prev++;
        temp /= 5;
      }
      table[i] = prev;
    }
    System.out.println(table[N]);
  }
}
