package org.haisia.p9375;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();

      if (n == 0) {
        sb.append(0).append("\n");
        continue;
      }

      sc.nextLine();
      Map<String, Set<String>> table = new HashMap<>();
      for (int j = 0; j < n; j++) {
        String[] inputs = sc.nextLine().split(" ");
        Set<String> set = table.getOrDefault(inputs[1], new HashSet<>());
        set.add(inputs[0]);
        table.put(inputs[1], set);
      }

      int result = 1;
      for (Map.Entry<String, Set<String>> entry : table.entrySet()) {
        result *= (entry.getValue().size() + 1);
      }
      sb.append(result - 1).append("\n");
    }
    System.out.println(sb);
  }
}
