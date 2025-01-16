package org.haisia.p1018;

import java.util.Scanner;

class Main {

  // W : true, B : false;
  static boolean[][] board;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    generateBoard(N, M, sc);

    // 1. board 순회하며 아래 로직 반복
    // 2. 시작지점 true 기준 8 x 8 순회하며 칠해야하 할 칸 수 찾기
    // 3. 시작지점 false 기준 8 x 8 순회하며 칠해야하 할 칸 수 찾기
    // 4. 최솟값 result 에 저장

    int _N = N - 8;
    int _M = M - 8;

    int result = Integer.MAX_VALUE;
    for (int i = 0; i <= _N; i++) {
      for (int j = 0; j <= _M; j++) {
        result = Math.min(getMinimumCountOfTarget(i,j), result);
      }
    }

    System.out.println(result);
  }

  private static void generateBoard(int N, int M, Scanner sc) {
    board = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = sc.next();
      for (int j = 0; j < M; j++) {
        if (line.charAt(j) == 'W') {
          board[i][j] = true;
        }
      }
    }
  }

  private static int getMinimumCountOfTarget(int startN, int startM) {
    int result = 0;

    boolean expectValue = true;
    for (int i = startN; i < startN + 8; i++) {
      for (int j = startM; j < startM + 8; j++) {
        if (board[i][j] == expectValue) result++;
        expectValue = !expectValue;
      }
      expectValue = !expectValue;
    }
    return Math.min(result, 64-result);
  }

}
