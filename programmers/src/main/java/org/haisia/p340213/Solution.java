package org.haisia.p340213;

class Solution {

  Integer video_len;
  Integer pos;
  Integer op_start;
  Integer op_end;

  public String solution(String _video_len, String _pos, String _op_start, String _op_end, String[] commands) {

    /*
    * prev : max(0, now - 10s)
    * next : min(end, now + 10s)
    * skip : if op_s <= now <= op_e;
    *           now = op_e
    *
    * */

    video_len = parseStringToSeconds(_video_len);
    pos = parseStringToSeconds(_pos);
    op_start = parseStringToSeconds(_op_start);
    op_end = parseStringToSeconds(_op_end);
    applyOp();

    for (String command : commands) {
      if (command.equals("prev")) prev();
      else next();
    }

    return parsePosToString();
  }

  public int parseStringToSeconds(String str) {
    String[] split = str.split(":");
    return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
  }

  public void applyOp() {
    if (pos >= op_start && pos < op_end) pos = op_end;
  }

  public void prev() {
    pos = Math.max(0, pos - 10);
    applyOp();
  }

  public void next() {
    pos = Math.min(video_len, pos + 10);
    applyOp();
  }

  public String parsePosToString() {
    Integer m = pos / 60;
    Integer s = pos % 60;
    String M = m < 10 ? "0" + m : m.toString();
    String S = s < 10 ? "0" + s : s.toString();
    return M + ":" + S;
  }
}