package org.haisia.practice.sort.answer;

import org.haisia.practice.sort.ISort;

public class AInsertSort<T extends Comparable<T>> implements ISort<T> {

  @Override
  public T[] sort(T[] target) {
    if (target == null || target.length <= 1) {
      return target;
    }

    for (int i = 1; i < target.length; i++) {
      T key = target[i];
      int j = i - 1;

      while (j >= 0 && target[j].compareTo(key) > 0) {
        target[j + 1] = target[j];
        j--;
      }

      target[j + 1] = key;
    }

    return target;
  }
}