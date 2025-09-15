package org.haisia.p389478;

class Solution {

  // n = 총 개수, w = 한줄 개수, num = 박스 번호.
  // 박스 번호 1부터 시작
  public int solution(int n, int w, int num) {
    int answer = 0;

    int target_i = 0;
    int target_j = 0;

    boolean[][] board = new boolean[101][w];
    int board_i = 0;
    int board_j = 0;
    int flag = 1;
    for (int i = 0; i < n; i++) {

      if (num - 1 == i) {
        target_i = board_i;
        target_j = board_j;
      }

      board[board_i][board_j] = true;
      board_j += flag;
      if (board_j >= w || board_j < 0) {
        flag *= -1;
        board_j += flag;
        board_i++;
      }
    }

    for (int i = target_i; i <101; i++) {
      if (board[i][target_j]) answer++;
      else break;
    }

    return answer;
  }
}