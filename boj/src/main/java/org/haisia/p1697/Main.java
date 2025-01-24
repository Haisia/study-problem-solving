package org.haisia.p1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    if (N >= K) {
      System.out.println(N - K);
      return;
    }

    // 여기부터는   수빈 ---- 동생   위치가 보장됨( N < K )
    // a[n] == min ( a[n-1] , a[n+1], a[n/2] ) + 1

    int[] arr = new int[K * 2 + 1];
    boolean[] visited = new boolean[K * 2 + 1];
    Arrays.fill(arr, Integer.MAX_VALUE);

    arr[N] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.offer(N);
    visited[N] = true;

    while (!q.isEmpty()) {
      Integer target = q.poll();

      if (target == K) break;

      if (target - 1 >= 0 && !visited[target - 1]) {
        visited[target - 1] = true;
        q.offer(target - 1);
        arr[target - 1] = arr[target] + 1;
      }

      if (target + 1 <= 2 * K && !visited[target + 1]) {
        visited[target + 1] = true;
        q.offer(target + 1);
        arr[target + 1] = arr[target] + 1;
      }

      if (target * 2 <= 2 * K && !visited[target * 2]) {
        visited[target * 2] = true;
        q.offer(target * 2);
        arr[target * 2] = arr[target] + 1;
      }
    }
    System.out.println(arr[K]);
  }
}