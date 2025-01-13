package org.haisia.p15829;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    String word = sc.next();

    final int r = 31;
    final int m = 1234567891;

    long result = 0;
    long power = 1;

    for (int i = 0; i < length; i++) {
      int ai = word.charAt(i) - 'a' + 1;
      result = (result + ai * power) % m;
      power = (power * r) % m;
    }

    System.out.println(result);
  }
}