package org.haisia.practice.heap;

public interface IHeap<T extends Comparable<T>> {

  /**
   * 힙에 새로운 요소를 추가합니다.
   *
   * @param element 추가할 요소
   */
  void insert(T element);

  /**
   * 힙의 루트 요소를 제거하고 반환합니다.
   * 이 메서드는 힙 속성을 유지하면서 작업을 수행합니다.
   *
   * @return 제거된 루트 요소
   */
  T extract();

  /**
   * 힙의 루트 요소(최대값 또는 최소값)를 반환하지만 제거하지 않습니다.
   *
   * @return 루트 요소
   */
  T peek();

  /**
   * 힙이 비어 있는지 확인합니다.
   *
   * @return 비어 있으면 true, 그렇지 않으면 false
   */
  boolean isEmpty();

  /**
   * 힙의 현재 요소 개수를 반환합니다.
   *
   * @return 힙 크기
   */
  int size();

}
