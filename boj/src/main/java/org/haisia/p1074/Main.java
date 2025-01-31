package org.haisia.p1074;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int r = sc.nextInt();
    int c = sc.nextInt();

    int length = (int)Math.pow(2, N);

    int offset = 0;
    while (
      !( (r == 0 || r == 1) && (c == 0 || c == 1) )
    ) {
      length /= 2;

      if (c - length >= 0) {
        c -= length;
        offset += length * length;
      }

      if (r - length >= 0) {
        r -= length;
        offset += 2 * (length * length);
      }
    }
    System.out.println((2 * r + c + offset));
  }
}
