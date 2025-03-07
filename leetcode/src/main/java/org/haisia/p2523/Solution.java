package org.haisia.p2523;

class Solution {
  public int[] closestPrimes(int left, int right) {

    boolean[] notSosoo = new boolean[right + 1];
    notSosoo[0] = true;
    notSosoo[1] = true;

    for (int i = 2; i <= right; i++) {
      if (notSosoo[i]) continue;
      int target = i * 2;
      while (target <= right) {
        notSosoo[target] = true;
        target += i;
      }
    }

    int prev = 0;
    int minLength = Integer.MAX_VALUE;
    int[] result = null;
    for (int i = left; i <= right; i++) {
      if(notSosoo[i]) continue;

      if (prev == 0) {
        prev = i;
      } else {
        int length = i - prev;
        if (length < minLength) {
          minLength = length;
          result = new int[]{prev, i};
        }
      }
      prev = i;
    }

    if (minLength == Integer.MAX_VALUE) return new int[]{-1, -1};

    return result;
  }
}
