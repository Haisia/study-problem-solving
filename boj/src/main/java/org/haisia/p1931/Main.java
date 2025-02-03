package org.haisia.p1931;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    List<int[]> meetings = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      meetings.add(new int[]{start, end});
    }

    meetings.sort((a, b) -> {
      if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
      return Integer.compare(a[1], b[1]);
    });

    int count = 0;
    int prevEndTime = 0;

    for (int[] meeting : meetings) {
      if (meeting[0] >= prevEndTime) {
        prevEndTime = meeting[1];
        count++;
      }
    }

    System.out.println(count);
  }
}