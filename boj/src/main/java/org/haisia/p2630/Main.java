package org.haisia.p2630;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int whiteCount = 0;
    int blueCount = 0;

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    // {n, m, length}
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0, N});

    while (!q.isEmpty()) {
      int[] target = q.poll();

      int check = 0;
      int allCheck = 0;
      boolean flag = false;
      for (int i = target[0]; i < target[0] + target[2]; i++) {
        for (int j = target[1]; j < target[1] + target[2]; j++) {
          if (arr[i][j] == 1) {
            check++;
          }
          allCheck++;
          if (check > 0 && check != allCheck) {
            flag = true;
            break;
          }
        }
        if (flag) break;
      }

      if (check == 0) whiteCount++;
      else if (check == target[2] * target[2]) blueCount++;
      else if (target[2]/2 > 0){
        int length = target[2] / 2;
        q.offer(new int[]{target[0], target[1], length});
        q.offer(new int[]{target[0] + length, target[1], length});
        q.offer(new int[]{target[0], target[1] + length, length});
        q.offer(new int[]{target[0] + length, target[1] + length, length});
      }
    }
    System.out.println(whiteCount);
    System.out.println(blueCount);
  }
}
