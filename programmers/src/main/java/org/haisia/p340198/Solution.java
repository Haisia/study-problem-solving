package org.haisia.p340198;

import java.util.Arrays;

class Solution {
  public int solution(int[] mats, String[][] park) {
    int[] sorted = Arrays.stream(mats).sorted().toArray();

    for (int k = mats.length - 1; k >= 0; k--) {
      int mat = sorted[k];
      for (int i = 0; i < park.length; i++) {
        for (int j = 0; j < park[0].length; j++) {
          if (check(new int[] {i,j}, mat, park)) return mat;
        }
      }
    }
    return -1;
  }

  public boolean check(int[] point, int size, String[][] park) {
    try {
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (!park[point[0] + i][point[1] + j].equals("-1"))
            return false;
        }
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}