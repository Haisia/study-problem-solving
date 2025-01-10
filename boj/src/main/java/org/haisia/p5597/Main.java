package org.haisia.p5597;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean[] isSubmitted = new boolean[31];
    for (int i = 0; i < 28; i++) {
      isSubmitted[sc.nextInt()] = true;
    }
    for (int i = 1; i <= 30; i++) {
      if(!isSubmitted[i]) System.out.println(i);
    }
  }
}
