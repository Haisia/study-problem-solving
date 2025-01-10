package org.haisia.p2420;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    System.out.println((Math.max(a, b) - Math.min(a, b)));
  }
}
