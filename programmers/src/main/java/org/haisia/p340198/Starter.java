package org.haisia.p340198;

public class Starter {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int answer = solution.solution(
      new int[]{5, 3, 2},
      new String[][]{
        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
      }
    );
    System.out.println(answer);
  }
}
