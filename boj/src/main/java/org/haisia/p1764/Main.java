package org.haisia.p1764;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int eme = sc.nextInt();
    int qh = sc.nextInt();

    Set<String> table = new HashSet<>();
    for (int i = 0; i < eme; i++) {
      table.add(sc.next());
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < qh; i++) {
      String name = sc.next();
      if (table.contains(name)) {
        result.add(name);
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(result.size()).append("\n");

    result.sort(Comparator.naturalOrder());
    result.forEach(s-> sb.append(s).append("\n"));
    System.out.println(sb);
  }
}
