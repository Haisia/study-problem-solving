package org.haisia.p9012;

import java.util.Scanner;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    sc.nextLine();
    for (int i = 0; i < repeat; i++) {
      String word = sc.nextLine();
      if (isVps(word)) sb.append("YES\n");
      else sb.append("NO\n");
    }
    System.out.println(sb);
  }

  private static boolean isVps(String word) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      // 스택이 비어있으면 push
      //       비어있지 않고 c가 여는괄호면 push
      //                   c가 닫는괄호이면 pop

      if (stack.isEmpty()) {
        if (c == ')') return false;
        stack.push(c);
      }
      else if (c == '(') stack.push(c);
      else stack.pop();
    }

    return stack.isEmpty();
  }
}
