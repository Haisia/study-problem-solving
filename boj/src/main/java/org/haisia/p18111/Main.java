package org.haisia.p18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] s = bf.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);
    int B = Integer.parseInt(s[2]);

    int max = 0;
    int min = 256;
    // <높이, 카운트>
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] s1 = bf.readLine().split(" ");

      for (int j = 0; j < M; j++) {
        int input = Integer.parseInt(s1[j]);
        Integer count = map.getOrDefault(input, 0) + 1;
        map.put(input, count);

        max = Math.max(max, input);
        min = Math.min(min, input);
      }
    }

    // {시간, 높이}
    int[] result = null;
    for (int height = min; height <= max; height++) {
      int addBlock = 0;
      int removeBlock = 0;
      int currentTime = 0;

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        Integer targetHeight = entry.getKey();
        Integer count = entry.getValue();

        int dif = height - targetHeight;
        if (dif > 0) removeBlock += dif * count;
        else if (dif < 0) addBlock -= dif * count;
      }

      currentTime = addBlock * 2 + removeBlock;
      int needBlock = removeBlock - addBlock;

      if (needBlock > B) continue;
      if (result == null || result[0] > currentTime) result = new int[]{currentTime, height};
      else if (result[0] == currentTime && result[1] < height) {
        result = new int[]{currentTime, height};
      }
    }
    System.out.println(result[0] + " " + result[1]);
  }
}
