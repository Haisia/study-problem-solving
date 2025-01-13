package org.haisia.p10989;

import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int totalCount = Integer.parseInt(br.readLine());

    int[] cache = new int[10001];
    for (int i = 0; i < totalCount; i++) {
      cache[Integer.parseInt(br.readLine())]++;
    }

    for (int i = 1; i < cache.length; i++) {
      for (int j = 0; j < cache[i]; j++) {
        sb.append(i).append('\n');
      }
    }

    System.out.println(sb);
  }
}