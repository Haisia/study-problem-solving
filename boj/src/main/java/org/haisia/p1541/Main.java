package org.haisia.p1541;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();

    boolean flag = false;
    int result = 0;
    int lt = 0;
    for (int i = 0; i < word.length(); i++) {
      if ((word.charAt(i) - '0') >= 0 && (word.charAt(i) - '0') <= 9) {
        continue;
      }
      char c = word.charAt(i);

      int value = Integer.parseInt(word.substring(lt, i));
      if (flag) result -= value;
      else result += value;

      if (c == '-') flag = true;
      lt = i + 1;
    }
    int value = Integer.parseInt(word.substring(lt));
    if (flag) result -= value;
    else result += value;

    System.out.println(result);
  }
}
