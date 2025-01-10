package org.haisia.p10699;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Main {
  public static void main(String[] args) {
    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
  }
}
