package org.haisia.p10845;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();
    sc.nextLine();

    StringBuilder sb = new StringBuilder();
    Deque<Integer> q = new LinkedList<>();
    for (int i = 0; i < repeat; i++) {
      String[] command = sc.nextLine().split(" ");

      switch (command[0]) {
        case "push":
          q.offer(Integer.parseInt(command[1]));
          break;
        case "pop":
          sb.append(q.isEmpty() ? -1 : q.pop()).append("\n");
          break;
        case "size":
          sb.append(q.size()).append("\n");
          break;
        case "empty":
          sb.append(q.isEmpty() ? 1 : 0).append("\n");
          break;
        case "front":
          sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
          break;
        case "back":
          sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }
}
