package org.haisia.p10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    char[][] board = new char[N][N];

    for (int i = 0; i < N; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < N; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    System.out.println(unsickCase(board, new boolean[N][N]) + " " + sickCase(board, new boolean[N][N]));

  }

  public static int unsickCase(char[][] board, boolean[][] visited) {
    int result = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (visited[i][j]) continue;
        result++;
        char target = board[i][j];

        // {i, j }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
          int[] poll = queue.poll();
          int _i = poll[0];
          int _j = poll[1];

          // 동 서 남 북
          int[] di = {0, 0, 1, -1};
          int[] dj = {1, -1, 0, 0};

          for (int k = 0; k < 4; k++) {
            if (checkConditionUnsick(board, visited, _i + di[k], _j + dj[k], target, board.length)) {
              visited[_i + di[k]][_j + dj[k]] = true;
              queue.offer(new int[]{_i + di[k], _j + dj[k]});
            }
          }
        }
      }
    }

    return result;
  }

  public static boolean checkConditionUnsick(char[][] board, boolean[][] visited, int i, int j, char target, int N) {
    if (i < 0 || i >= N || j < 0 || j >= N) return false;
    if (board[i][j] != target) return false;
    if (visited[i][j]) return false;
    return true;
  }

  public static int sickCase(char[][] board, boolean[][] visited) {
    int result = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (visited[i][j]) continue;
        result++;
        char target = board[i][j];

        // {i, j }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
          int[] poll = queue.poll();
          int _i = poll[0];
          int _j = poll[1];

          // 동 서 남 북
          int[] di = {0, 0, 1, -1};
          int[] dj = {1, -1, 0, 0};

          for (int k = 0; k < 4; k++) {
            if (checkConditionSick(board, visited, _i + di[k], _j + dj[k], target, board.length)) {
              visited[_i + di[k]][_j + dj[k]] = true;
              queue.offer(new int[]{_i + di[k], _j + dj[k]});
            }
          }

        }
      }
    }

    return result;
  }

  public static boolean checkConditionSick(char[][] board, boolean[][] visited, int i, int j, char target, int N) {
    if (i < 0 || i >= N || j < 0 || j >= N) return false;
    if (visited[i][j]) return false;

    if ((target == 'R' || target == 'G') && board[i][j] == 'B') return false;
    if (target == 'B' && (board[i][j] == 'R' || board[i][j] == 'G')) return false;

    return true;
  }
}
