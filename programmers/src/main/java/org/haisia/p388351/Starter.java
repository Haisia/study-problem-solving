package org.haisia.p388351;

public class Starter {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.solution(
      new int[]{700, 800, 1100},
      new int[][]{
        {710, 2359, 1050, 700, 650, 631, 659},
        {800, 801, 805, 800, 759, 810, 809},
        {1105, 1001, 1002, 600, 1059, 1001, 1100}
      }, 5));
  }
}
