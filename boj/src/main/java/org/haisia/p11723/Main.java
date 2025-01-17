package org.haisia.p11723;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();
    sc.nextLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String[] command = sc.nextLine().split(" ");

      switch (command[0]) {
        case "add":
          set.add(Integer.parseInt(command[1]));
          break;
        case "remove":
          set.remove(Integer.parseInt(command[1]));
          break;
        case "check":
          sb.append(set.contains(Integer.parseInt(command[1])) ? 1 : 0).append("\n");
          break;
        case "toggle":
          int value = Integer.parseInt(command[1]);
          boolean contains = set.contains(value);
          if (contains) set.remove(value);
          else set.add(value);
          break;
        case "all":
          for (int j = 1; j <= 20; j++) {
            set.add(j);
          }
          break;
        case "empty":
          set.clear();
          break;
      }
    }
    System.out.println(sb);
  }
}
