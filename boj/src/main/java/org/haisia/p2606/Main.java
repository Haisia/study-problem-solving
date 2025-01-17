package org.haisia.p2606;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int countOfComputer = sc.nextInt();
    int countOfNetwork = sc.nextInt();
    boolean[] arr = new boolean[countOfComputer + 1];

    Map<Integer, Set<Integer>> table = new HashMap<>();
    for (int i = 0; i < countOfNetwork; i++) {
      int source = sc.nextInt();
      int dist = sc.nextInt();
      table.putIfAbsent(source, new HashSet<>());
      table.putIfAbsent(dist, new HashSet<>());
      table.get(source).add(dist);
      table.get(dist).add(source);
    }

    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    arr[1] = true;
    int count = 0;
    while (!q.isEmpty()) {
      Integer target = q.poll();
      Set<Integer> integers = table.get(target);
      if (integers != null) {
        for (Integer integer : integers) {
          if (!arr[integer]) {
            arr[integer] = true;
            count++;
            q.offer(integer);
          }
        }
      }
    }
    System.out.println(count);
  }
}