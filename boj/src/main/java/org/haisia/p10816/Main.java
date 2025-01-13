package org.haisia.p10816;

import java.util.Scanner;

class Main {
  static int OFFSET = 10000000;

  public static void main(String[] args) {
    int[] arr = new int[OFFSET*2 + 1];

    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    for (int i = 0; i < count; i++) {
      arr[sc.nextInt() + OFFSET]++;
    }

    int targetCount = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < targetCount; i++) {
      sb.append(arr[sc.nextInt() + OFFSET]).append("\n");
    }
    System.out.println(sb);
  }
}
