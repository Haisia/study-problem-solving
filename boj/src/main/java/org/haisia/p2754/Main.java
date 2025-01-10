package org.haisia.p2754;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Map<String, String> table = new HashMap<>();
    table.put("A+", "4.3");
    table.put("A0", "4.0");
    table.put("A-", "3.7");
    table.put("B+", "3.3");
    table.put("B0", "3.0");
    table.put("B-", "2.7");
    table.put("C+", "2.3");
    table.put("C0", "2.0");
    table.put("C-", "1.7");
    table.put("D+", "1.3");
    table.put("D0", "1.0");
    table.put("D-", "0.7");
    table.put("F", "0.0");

    Scanner sc = new Scanner(System.in);
    System.out.println(table.get(sc.next()));

  }
}
