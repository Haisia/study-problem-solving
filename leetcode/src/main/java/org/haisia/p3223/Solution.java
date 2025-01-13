package org.haisia.p3223;

import java.util.Arrays;

class Solution {
  public int minimumLength(String s) {
    int[] arr = new int['z' - 'a' + 1];
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a']++;
    }
    System.out.println();
    return Arrays.stream(arr).map(n -> {
      if (n >= 3) {
        if (n % 2 == 0) return 2;
        else return 1;
      }
      return n;
    }).sum();
  }
}