package org.haisia.p10773;

import java.util.Scanner;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();

    for (int i = 0; i < repeat; i++) {
      int target = sc.nextInt();
      if (target == 0) stack.pop();
      else stack.push(target);
    }

    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    System.out.println(result);
  }
}
