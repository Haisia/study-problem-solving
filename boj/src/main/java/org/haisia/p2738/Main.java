package org.haisia.p2738;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rc = sc.nextInt();
    int cc = sc.nextInt();

    int[][] table = new int[rc][cc];

    for (int i = 0; i < rc; i++) {
      for (int j = 0; j < cc; j++) {
        table[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < rc; i++) {
      for (int j = 0; j < cc; j++) {
        table[i][j] += sc.nextInt();
        System.out.print(table[i][j] + " ");
      }
      System.out.println();
    }
  }
}
