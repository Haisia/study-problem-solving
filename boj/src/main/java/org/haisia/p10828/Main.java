package org.haisia.p10828;

import java.util.Scanner;
import java.util.Stack;

class Main {
  static Stack<Integer> stack;
  static StringBuilder result;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();
    sc.nextLine();

    stack = new Stack<>();
    result = new StringBuilder();
    for (int i = 0; i < repeat; i++) {
      String[] command = sc.nextLine().split(" ");

      if (command[0].equals("push")){
        stack.push(Integer.parseInt(command[1]));
      }
      else if (command[0].equals("pop")){
        result.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
      }
      else if (command[0].equals("size")){
        result.append(stack.size()).append("\n");
      }
      else if (command[0].equals("empty")){
        result.append(stack.isEmpty() ? 1 : 0).append("\n");
      }
      else if (command[0].equals("top")){
        result.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
      }
    }
    System.out.println(result);
  }
}
