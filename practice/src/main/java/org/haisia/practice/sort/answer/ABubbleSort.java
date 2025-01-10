package org.haisia.practice.sort.answer;

import org.haisia.practice.sort.ISort;

public class ABubbleSort<T extends Comparable<T>> implements ISort<T> {
  public T[] sort(T[] target) {
    if (target.length <= 1) {
      return target;
    }
    for (int i = target.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        T current = target[j];
        T next = target[j + 1];
        if (current.compareTo(next) > 0) {
          swap(target, j, j+1);
        }
      }
    }

    return target;
  }

  private void swap(T[] arr, int a, int b) {
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}