package org.haisia.p1400;

import java.util.Arrays;

class Solution {
  public boolean canConstruct(String s, int k) {
    if(s.length() < k) return false;
    int[] table = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      table[c-'a'] += 1;
    }

    return Arrays.stream(table)
      .filter(a-> a%2==1)
      .count() <= k;
  }
}