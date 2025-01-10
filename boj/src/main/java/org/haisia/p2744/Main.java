package org.haisia.p2744;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String target = sc.next();
    StringBuilder result = new StringBuilder();
    for (char c : target.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        c = (char) (c - 'a' + 'A');
      } else {
        c = (char) (c - 'A' + 'a');
      }
      result.append(c);
    }
    System.out.println(result);
  }
}
