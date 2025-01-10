package org.haisia.p2775;

/*
*   1 2 3 4 5 6 7 ... 호 수
* 0 1 2 3 4 5 6 7
* 1
* 2
* 3
* 4
* ... 층수
* */

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int caseCount = sc.nextInt();
    int[][] testCase = new int[caseCount][2];
    int maxRound = 0;
    int maxHo = 0;

    for (int i = 0; i < caseCount; i++) {
      int round = sc.nextInt();
      int ho = sc.nextInt();

      maxRound = Math.max(maxRound, round);
      maxHo = Math.max(maxHo, ho);

      testCase[i][0] = round;
      testCase[i][1] = ho;
    }

    long[][] board = draw(maxRound, maxHo);
    for (int i = 0; i < testCase.length; i++) {
      int round = testCase[i][0];
      int ho = testCase[i][1];
      System.out.println(board[round][ho]);
    }
  }

  public static long[][] draw(int maxRound, int maxHo) {
    long[][] board = new long[maxRound + 1][maxHo + 1];
    for (int i = 0; i < board[0].length; i++) {
      board[0][i] = i;
    }

    for (int round = 1; round <= maxRound; round++) {
      for (int ho = 1; ho <= maxHo; ho++) {
        board[round][ho] = board[round][ho - 1] + board[round - 1][ho];
      }
    }

    return board;
  }
}
