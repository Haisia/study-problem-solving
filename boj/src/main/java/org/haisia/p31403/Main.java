package org.haisia.p31403;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(a+b-c);
    System.out.println(Integer.parseInt(String.valueOf(a) + b) - c);
  }
}
