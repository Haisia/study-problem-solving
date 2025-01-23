package org.haisia.p18870;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] arr = new int[N];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
      set.add(arr[i]);
    }
    int[] sortedArr = set.stream().mapToInt(m -> m).sorted().toArray();

    StringBuilder sb = new StringBuilder();
    for (int target : arr) {
      int lt = 0;
      int rt = sortedArr.length - 1;

      int mt = 0;
      while (lt <= rt) {
        mt = (lt + rt) / 2;
        if (sortedArr[mt] == target) break;
        if (sortedArr[mt] < target) {
          lt = mt + 1;
        } else {
          rt = mt - 1;
        }
      }

      sb.append(mt).append(" ");
    }
    System.out.println(sb);
  }
}
