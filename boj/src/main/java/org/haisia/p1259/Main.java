package org.haisia.p1259;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder result = new StringBuilder();
    while (true) {
      String val = sc.next();
      if (val.equals("0")) break;

      StringBuilder sb = new StringBuilder(val);
      if(sb.reverse().toString().equals(val)) result.append("yes").append("\n");
      else result.append("no").append("\n");
    }

    System.out.println(result);
  }
}
