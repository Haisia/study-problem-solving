package org.haisia.p2523;

public class Run {
  public static void main(String[] args) {
    System.out.println();
    Solution s = new Solution();
    int[] ints = s.closestPrimes(19, 31);
    System.out.println(ints[0]);
    System.out.println(ints[1]);
  }
}
