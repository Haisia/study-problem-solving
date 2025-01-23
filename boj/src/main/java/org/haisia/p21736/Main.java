package org.haisia.p21736;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

  static char[][] map;
  static boolean[][] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    int[] start = null;
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String input = sc.nextLine();
      map[i] = input.toCharArray();
      if (input.contains("I")) {
        start = new int[] {input.indexOf("I"), i};
      }
    }

    visited = new boolean[N][M];
    Queue<int[]> q = new LinkedList<>();
    q.offer(start);
    visited[start[1]][start[0]] = true;

    // {동, 서, 남, 북}
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    int result = 0;
    while (!q.isEmpty()) {
      int[] target = q.poll();
      if (map[target[1]][target[0]] == 'P') result++;

      for (int i = 0; i < 4; i++) {
        int x = target[0] + dx[i];
        int y = target[1] + dy[i];
        if (isValid(x, y)) {
          q.offer(new int[]{x,y});
          visited[y][x] = true;
        }
      }
    }
    System.out.println(result == 0 ? "TT" : result);
  }

  static boolean isValid(int x, int y) {
    // 갈수있는 공간인지
    if (x < 0 || x >= map[0].length) return false;
    if (y < 0 || y >= map.length) return false;
    if (map[y][x] == 'X') return false;
    // 방문한적 없는지
    if (visited[y][x]) return false;
    return true;
  }
}
