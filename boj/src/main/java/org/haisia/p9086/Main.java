package org.haisia.p9086;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();

    List<String> targets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      targets.add(sc.next());
    }

    for (String target : targets) {
      System.out.println((String.valueOf(target.charAt(0)) + String.valueOf(target.charAt(target.length() - 1))));
    }
  }
}
