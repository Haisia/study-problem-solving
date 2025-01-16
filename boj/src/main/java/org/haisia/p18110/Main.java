package org.haisia.p18110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    if (n == 0) {
      bw.write("0\n");
      bw.flush();
      return;
    }

    int[] votes = new int[n];
    for (int i = 0; i < n; i++) {
      votes[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(votes);

    int excludeCount = (int) Math.round(n * 0.15);

    int sum = 0;
    for (int i = excludeCount; i < n - excludeCount; i++) {
      sum += votes[i];
    }

    int validCount = n - 2 * excludeCount;
    int avg = (int) Math.round((double) sum / validCount);

    bw.write(avg + "\n");
    bw.flush();
  }
}