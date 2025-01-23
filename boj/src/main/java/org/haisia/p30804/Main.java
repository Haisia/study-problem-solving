package org.haisia.p30804;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    MapHandler mh = new MapHandler();

    int lt = 0;
    int rt = 0;

    int result = 0;
    while (true) {
      if (lt > rt || rt >= arr.length) break;
      if (mh.size() > 2) {
        mh.remove(arr[lt++]);
        continue;
      }

      mh.add(arr[rt++]);
      if (mh.size() > 2) {
        continue;
      }

      result = Math.max(result, mh.thrSize());
    }
    System.out.println(result);
  }

  static class MapHandler {
    // <탕후루종류, 개수>
    Map<Integer, Integer> map = new HashMap<>();

    public void add(Integer target) {
      Integer count = map.getOrDefault(target, 0);
      map.put(target, count + 1);
    }

    public void remove(Integer target) {
      Integer count = map.get(target);
      count--;
      if (count == 0) map.remove(target);
      else map.put(target, count);
    }

    // 탕후루 종류 개수
    public int size() {
      return map.size();
    }

    // 탕후루 총 개수
    public int thrSize() {
      int result = 0;
      for (Integer value : map.values()) {
        result += value;
      }
      return result;
    }
  }
}
