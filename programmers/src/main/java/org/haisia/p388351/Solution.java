package org.haisia.p388351;

class Solution {
  public int solution(int[] schedules, int[][] timelogs, int startday) {
    int answer = 0;

    for (int i = 0; i < schedules.length; i++) {
      int expect = schedules[i];

      boolean flag = true;
      for (int day = 0; day < 7; day++) {
        int today = startday + day > 7 ? startday + day - 7 : startday + day;

        if (today == 6 || today == 7) {
          continue;
        }
        boolean isPass = checkEventPass(expect, timelogs[i][day]);
        if (!isPass) {
          flag = false;
          break;
        }
      }

      if (flag) answer++;
    }

    return answer;
  }

  public boolean checkEventPass(int expect, int actual) {
    expect += 10;
    if (expect % 100 >= 60) {
      expect += 40;
    }
    return expect >= actual;
  }
}