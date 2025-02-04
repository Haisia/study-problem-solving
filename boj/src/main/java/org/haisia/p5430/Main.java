package org.haisia.p5430;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Deque<Integer> dq = new LinkedList<>();

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    String temp = sc.nextLine();

    for (int i = 0; i < T; i++) {
      String commands = sc.nextLine();

      sc.nextLine();
      String[] array = sc.nextLine().replace("[", "").replace("]", "").split(",");

      for (String s : array) {
        if (s.isEmpty()) continue;
        dq.offer(Integer.parseInt(s));
      }

      Helper helper = new Helper(dq);

      boolean flag = false;
      for (int j = 0; j < commands.length(); j++) {
        if (!helper.task(commands.charAt(j))) {
          flag = true;
          break;
        }
      }
      if (flag) {
        System.out.println("error");
        continue;
      }

      StringBuilder sb = new StringBuilder();
      sb.append('[');
      if (helper.flag) {
        while (!dq.isEmpty()) {
          sb.append(dq.pollLast()).append(',');
        }
      } else {
        while (!dq.isEmpty()) {
          sb.append(dq.pollFirst()).append(',');
        }
      }
      if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
      sb.append(']');
      System.out.println(sb);
    }

  }

  static class Helper {
    Deque<Integer> dq;
    boolean flag = false;

    public Helper(Deque<Integer> dq) {
      this.dq = dq;
    }

    public boolean task(char command) {
      if (command == 'R') {
        flag = !flag;
      } else if (command == 'D') {

        if (dq.isEmpty()) return false;

        if (flag) {
          dq.pollLast();
        } else {
          dq.pollFirst();
        }
      }
      return true;
    }
  }
}
