package org.haisia.p10699;

import java.math.BigInteger;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger result = new BigInteger("0");
    while (sc.hasNextBigInteger()) {
      result = result.add(sc.nextBigInteger());
    }
    System.out.println(result);
  }
}
