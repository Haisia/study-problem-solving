package org.haisia.p5525;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();
    String target = sc.nextLine();

    // <n, count>
    Map<Integer, Integer> cache = new HashMap<>();
    for (int i = 0; i < target.length(); i++) {
      if (target.charAt(i) != 'I') continue;

      char expect = 'O';
      i++;
      int n = 0;
      while (i < target.length()) {
        if (target.charAt(i) != expect) break;
        if (expect == 'O') {
          expect = 'I';
        } else {
          expect = 'O';
          n++;
        }
        i++;
      }
      if (n >= N) cache.put(n, cache.getOrDefault(n,0) + 1);
      i--;
    }

    int result = 0;
    for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
      Integer n = entry.getKey();
      Integer count = entry.getValue();

      result += (n - N + 1) * count;
    }
    System.out.println(result);
  }
}
