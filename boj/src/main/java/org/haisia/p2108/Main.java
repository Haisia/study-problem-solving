package org.haisia.p2108;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeat = sc.nextInt();

    int[] arr = new int[repeat];
    int sum = 0;

    // value, count
    Map<Integer, Integer> table = new HashMap<>();
    for (int i = 0; i < repeat; i++) {
      int value = sc.nextInt();
      arr[i] = value;
      sum += value;

      table.put(value, table.getOrDefault(value, 0) + 1);
    }

    int maxFrequentCount = 0;
    Set<Integer> set = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
      if (entry.getValue() < maxFrequentCount) continue;
      if (entry.getValue() == maxFrequentCount) set.add(entry.getKey());
      else {
        set.clear();
        set.add(entry.getKey());
        maxFrequentCount = entry.getValue();
      }
    }

    int[] array = set.stream().mapToInt(n -> n).sorted().toArray();

    Arrays.sort(arr);
    System.out.println(Math.round((float) sum / repeat));
    System.out.println(arr[repeat / 2]);
    System.out.println(array.length == 1 ? array[0] : array[1]);
    System.out.println(arr[repeat - 1] - arr[0]);
  }
}
