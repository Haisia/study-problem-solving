package org.haisia.p1874;

import java.util.Scanner;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] sequence = new int[n];

    for (int i = 0; i < n; i++) {
      sequence[i] = sc.nextInt();
    }

    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int current = 1;

    for (int num : sequence) {
      while (current <= num) {
        stack.push(current++);
        sb.append("+\n");
      }

      if (stack.peek() == num) {
        stack.pop();
        sb.append("-\n");
      } else {
        System.out.println("NO");
        return;
      }
    }

    System.out.print(sb);
  }
}
