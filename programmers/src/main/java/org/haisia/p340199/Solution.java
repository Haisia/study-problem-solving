package org.haisia.p340199;

class Solution {
  public int solution(int[] wallet, int[] bill) {
    int answer = 0;

    while (!checkInputable(wallet, bill)) {
      bill = half(bill);
      answer++;
    }

    return answer;
  }

  public boolean checkInputable(int[] wallet, int[] bill) {
    return
      (bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
        (bill[1] <= wallet[0] && bill[0] <= wallet[1]);
  }

  public int[] half(int[] bill) {
    if (bill[0] <= bill[1]) bill[1] /= 2;
    else bill[0] /= 2;
    return bill;
  }
}