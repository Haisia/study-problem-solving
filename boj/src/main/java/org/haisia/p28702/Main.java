package org.haisia.p28702;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // 0 : 숫자, 1: Fizz, 2:Buzz, 3:FizzBuzz
    int[] table = new int[]{3, 0, 0, 1, 0, 2, 1, 0, 0, 1, 2, 0, 1, 0, 0};

    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String b = sc.next();
    String c = sc.next();

    int findCount = 0;
    int target = 0;
    if (a.charAt(0) >= '0' && a.charAt(0) <= '9') {
      findCount = 1;
      target = Integer.parseInt(a);
    } else if (b.charAt(0) >= '0' && b.charAt(0) <= '9') {
      findCount = 2;
      target = Integer.parseInt(b);
    } else if (c.charAt(0) >= '0' && c.charAt(0) <= '9') {
      findCount = 3;
      target = Integer.parseInt(c);
    }

    int status = table[(target + 4 - findCount) % 15];
    if (status == 1) System.out.println("Fizz");
    else if (status == 2) System.out.println("Buzz");
    else if (status == 3) System.out.println("FizzBuzz");
    else System.out.println(target + 4 - findCount);
  }
}
