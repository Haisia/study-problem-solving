package org.haisia.p1181;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();

    List<String> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      String word = sc.next();
      if (!list.contains(word)) list.add(word);
    }

    list.sort((a,b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      }
      return a.length() - b.length();
    });

    StringBuilder sb = new StringBuilder();
    for (String s : list) {
      sb.append(s).append("\n");
    }
    System.out.println(sb);
  }
}
