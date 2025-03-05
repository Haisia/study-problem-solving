package org.haisia.p9019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // D : 2n mod 10000
    // S : +9999 mod 10000
    // L : (n % 1000)*10 + round(n / 1000)
    // R : (n / 10) + (n % 10) * 1000

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      boolean[] visited = new boolean[10000];
      String[] histories = new String[10000];

      String[] inputs = sc.nextLine().split(" ");
      int start = Integer.parseInt(inputs[0]);
      int target = Integer.parseInt(inputs[1]);
      Queue<Integer> q = new LinkedList<>();
      q.offer(start);
      visited[start] = true;

      while (!q.isEmpty()) {
        Integer value = q.poll();

        int D = task('D', value);
        if (!visited[D]) {
          visited[D] = true;
          q.offer(D);
          histories[D] = histories[value] == null ? "D" : histories[value] + "D";
          if (D == target) {
            sb.append(histories[D]).append("\n");
            break;
          }
        }

        int S = task('S', value);
        if (!visited[S]) {
          visited[S] = true;
          q.offer(S);
          histories[S] = histories[value] == null ? "S" : histories[value] + "S";
          if (S == target) {
            sb.append(histories[S]).append("\n");
            break;
          }
        }

        int L = task('L', value);
        if (!visited[L]) {
          visited[L] = true;
          q.offer(L);
          histories[L] = histories[value] == null ? "L" : histories[value] + "L";
          if (L == target) {
            sb.append(histories[L]).append("\n");
            break;
          }
        }

        int R = task('R', value);
        if (!visited[R]) {
          visited[R] = true;
          q.offer(R);
          histories[R] = histories[value] == null ? "R" : histories[value] + "R";
          if (R == target) {
            sb.append(histories[R]).append("\n");
            break;
          }
        }
      }
    }

    System.out.println(sb);
  }
  static int task(char command, int target) {
    switch (command) {
      case 'D':
        return target * 2 % 10000;
      case 'S':
        return (target + 9999) % 10000;
      case 'L':
        return (target % 1000) * 10 + (target / 1000);
      case 'R':
        return (target / 10) + (target % 10) * 1000;
      default:
        return target;
    }
  }
}
