package org.haisia.p30802;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int personCount = sc.nextInt();
    int[] sizeTable = new int[6];

    for (int i = 0; i < 6; i++) {
      sizeTable[i] = sc.nextInt();
    }

    int T = sc.nextInt();
    int P = sc.nextInt();

    int shirtBundles = 0;
    for (int size : sizeTable) {
      shirtBundles += (size + T - 1) / T;
    }

    int penBundles = personCount / P;
    int remainingPens = personCount % P;

    System.out.println(shirtBundles);
    System.out.println(penBundles + " " + remainingPens);
  }
}
