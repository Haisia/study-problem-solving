package org.haisia.p7662;

import java.util.Scanner;
import java.util.TreeMap;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(sc.nextLine());
      MyQueue queue = new MyQueue();
      for (int j = 0; j < k; j++) {
        String[] commands = sc.nextLine().split(" ");
        queue.task(commands);
      }
      queue.print(sb);
    }
    System.out.println(sb);
  }

  static class MyQueue {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    void task(String[] commands) {
      int value = Integer.parseInt(commands[1]);

      if (commands[0].equals("I")) {
        input(value);
      } else if (commands[0].equals("D")) {
        if (treeMap.isEmpty()) return;
        if (value == 1) delete(treeMap.lastKey());
        else delete(treeMap.firstKey());
      }
    }

    void input(int value) {
      Integer currentValue = treeMap.getOrDefault(value, 0);
      treeMap.put(value, currentValue + 1);
    }

    void delete(int value) {
      if (!treeMap.containsKey(value)) return;

      Integer count = treeMap.get(value);
      if (count == 1) {
        treeMap.remove(value);
      } else {
        treeMap.put(value, count - 1);
      }
    }

    void print(StringBuilder sb) {
      if (treeMap.isEmpty()) {
        sb.append("EMPTY\n");
      } else if (treeMap.size() == 1) {
        Integer value = treeMap.firstKey();
        sb.append(value).append(" ").append(value).append("\n");
      } else {
        Integer firstKey = treeMap.firstKey();
        Integer lastKey = treeMap.lastKey();
        sb.append(lastKey).append(" ").append(firstKey).append("\n");
      }
    }
  }
}