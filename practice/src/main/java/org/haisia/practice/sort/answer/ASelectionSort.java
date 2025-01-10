package org.haisia.practice.sort.answer;

import org.haisia.practice.sort.ISort;

public class ASelectionSort<T extends Comparable<T>> implements ISort<T> {
  public T[] sort(T[] target) {
    for (int i = 0; i < target.length; i++) {
      int minIdx = i;
      for (int j = i + 1; j < target.length; j++) {
        T minValue = target[minIdx];
        T currentValue = target[j];
        if (minValue.compareTo(currentValue) > 0) {
          minIdx = j;
        }
      }
      swap(target, i, minIdx);
    }
    return target;
  }

  public void swap(T[] arr, int a, int b) {
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}