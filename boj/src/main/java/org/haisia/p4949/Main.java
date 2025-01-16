package org.haisia.p4949;

import java.util.Scanner;
import java.util.Stack;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();
    while (true) {
      String word = sc.nextLine();

      if (word.equals(".")){
        System.out.println(sb);
        return;
      }

      if (isComplete(word)) sb.append("yes").append("\n");
      else sb.append("no").append("\n");
    }
  }

  static boolean isComplete(String word) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < word.length(); i++) {
      char target = word.charAt(i);
      if (target != '(' && target != ')' && target != '[' && target != ']') continue;

      // target 은 ( ) [ ] 넷 중 하나.
      // target 이 ( [ 일경우 push
      // target 이 ) ] empty 검사
      //                empty 일경우 false
      //                empty 아닐경우 peek 하여 짝이 아니면 false
      //                짝일경우 pop

      if (target == '(' || target == '[') stack.push(target);
      else if (stack.isEmpty()) return false;
      else if (getMatchChar(stack.peek()) == target) stack.pop();
      else return false;
    }
    return stack.isEmpty();
  }

  static Character getMatchChar(char target) {
    if (target == '(') return ')';
    if (target == '[') return ']';
    return null;
  }
}
