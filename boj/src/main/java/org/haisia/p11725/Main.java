package org.haisia.p11725;

import java.util.*;

class Main {

  static Map<Integer, Set<Integer>> map = new HashMap<>();
  static int[] results = null;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i < N; i++) {
      String[] inputs = sc.nextLine().split(" ");
      Set<Integer> set1 = map.getOrDefault(Integer.parseInt(inputs[0]), new HashSet<>());
      set1.add(Integer.parseInt(inputs[1]));
      map.put(Integer.parseInt(inputs[0]), set1);

      Set<Integer> set2 = map.getOrDefault(Integer.parseInt(inputs[1]), new HashSet<>());
      set2.add(Integer.parseInt(inputs[0]));
      map.put(Integer.parseInt(inputs[1]), set2);
    }

    results = new int[N + 1];
    dfs(1);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i < results.length; i++) {
      sb.append(results[i]).append("\n");
    }
    System.out.println(sb);
  }

  static void dfs(int parent) {
    Set<Integer> children = map.get(parent);

    for (Integer child : children) {
      if (child == parent) continue;
      if (results[child] != 0) continue;
      results[child] = parent;
      dfs(child);
    }
  }
}
