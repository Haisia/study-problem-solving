package org.haisia.p916;

import java.util.List;

public class Run {
  public static void main(String[] args) {
    Solution solution = new Solution();
    List<String> result = solution.wordSubsets(
      new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
      new String[]{"e", "o"}
    );
    System.out.println("result = " + result);
    System.out.println();
  }
}
