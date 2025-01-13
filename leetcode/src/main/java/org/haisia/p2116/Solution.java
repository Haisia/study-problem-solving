package org.haisia.p2116;

class Solution {
  public boolean canBeValid(String s, String locked) {
    if (s.length() % 2 == 1) return false;

    int open = 0, flexible = 0;
    for (int i = 0; i < s.length(); i++) {
      boolean isFlexible = locked.charAt(i) == '0';
      if (isFlexible) {
        flexible++;
      } else if (s.charAt(i) == '(') {
        open++;
      } else {
        if (open > 0) open--;
        else if (flexible > 0) flexible--;
        else return false;
      }
    }

    int close = 0;
    flexible = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      boolean isFlexible = locked.charAt(i) == '0';
      if (isFlexible) {
        flexible++;
      } else if (s.charAt(i) == ')') {
        close++;
      } else {
        if (close > 0) close--;
        else if (flexible > 0) flexible--;
        else return false;
      }
    }

    return true;
  }
}