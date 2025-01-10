package org.haisia.practice.sort;

public interface ISort<T extends Comparable<T>> {
  /**
   * 배열을 정렬 알고리즘을 사용하여 정렬합니다.
   * @param target 정렬할 배열
   * @return 정렬된 결과
   */
  T[] sort(T[] target);
}
