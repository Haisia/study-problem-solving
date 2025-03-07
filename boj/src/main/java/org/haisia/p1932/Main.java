package org.haisia.p1932;

import java.util.Scanner;

class Main {
  static int n = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[][] arr = new int[n][n];
    int result = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        int input = sc.nextInt();
        if (i == 0 && j == 0) arr[i][j] = input;
        else {
          int[] leftParent = getLeftParent(i, j);
          int[] rightParent = getRightParent(i, j);
          arr[i][j] = Math.max(arr[leftParent[0]][leftParent[1]], arr[rightParent[0]][rightParent[1]]) + input;
        }
        result = Math.max(result, arr[i][j]);
      }
    }

    System.out.println(result);
  }

  static int[] getLeftParent(int i, int j) {
    int _i = Math.max(0, i-1);
    int _j = Math.max(0, j-1);

    return new int[]{_i, _j};
  }

  static int[] getRightParent(int i, int j) {
    int _i = Math.max(0, i-1);
    int _j = Math.min(j, i-1);

    return new int[]{_i, _j};
  }
}
