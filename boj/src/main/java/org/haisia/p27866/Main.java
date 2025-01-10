package org.haisia.p27866;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    int target = sc.nextInt();
    System.out.println(word.charAt(target - 1));
  }
}
