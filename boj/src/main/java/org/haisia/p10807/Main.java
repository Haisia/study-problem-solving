package org.haisia.p10807;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int totalCount = sc.nextInt();
    Map<Integer, Integer> table = new HashMap<>();
    for (int i = 0; i < totalCount; i++) {
      Integer value = sc.nextInt();
      table.put(value,table.getOrDefault(value, 0) + 1);
    }
    Integer key = sc.nextInt();

    System.out.println(table.getOrDefault(key, 0));
  }
}