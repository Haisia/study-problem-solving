package org.haisia.p17219;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    Map<String, String> table = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] inputs = sc.nextLine().split(" ");
      table.put(inputs[0], inputs[1]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      sb.append(table.get(sc.next())).append("\n");
    }
    System.out.println(sb);
  }
}
