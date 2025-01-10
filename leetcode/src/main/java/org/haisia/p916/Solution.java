package org.haisia.p916;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> wordSubsets(String[] words1, String[] words2) {
    if (words2 == null || words2.length == 0) return List.of(words1);

    int[] words2MaxCount = new int[26];
    for (String word : words2) {
      int[] wordCount = splitStringToArray(word);
      for (int i = 0; i < 26; i++) {
        words2MaxCount[i] = Math.max(words2MaxCount[i], wordCount[i]);
      }
    }

    List<String> result = new ArrayList<>();
    for (String word : words1) {
      int[] wordCount = splitStringToArray(word);
      if (isUniversal(wordCount, words2MaxCount)) result.add(word);
    }

    return result;
  }

  private int[] splitStringToArray(String target) {
    int[] counts = new int[26];
    for (char c : target.toCharArray()) {
      counts[c - 'a']++;
    }
    return counts;
  }

  private boolean isUniversal(int[] wordCount, int[] words2MaxCount) {
    for (int i = 0; i < 26; i++) {
      if (wordCount[i] < words2MaxCount[i]) return false;
    }
    return true;
  }
}
