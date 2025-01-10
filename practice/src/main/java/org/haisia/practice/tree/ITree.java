package org.haisia.practice.tree;

public interface ITree<E extends Comparable<E>> {

  /**
   *  트리에 새로운 요소를 추가합니다.
   *
   * @param element 추가할 요소
   * @return 요소가 성공적으로 추가되었으면 true, 이미 존재하면 false
   */
  boolean insert(E element);

  /**
   *  트리에서 특정 요소를 삭제합니다.
   *
   * @param element 삭제할 요소
   * @return 요소가 성공적으로 삭제되었으면 true, 존재하지 않으면 false
   */
  boolean delete(E element);

  /**
   *  트리에서 특정 값을 검색합니다.
   *
   * @param element 검색할 요소
   * @return 요소가 존재하면 true, 없으면 false
   */
  boolean search(E element);

  /**
   *  트리에서 가장 작은 값을 찾습니다.
   *
   * @return 트리에서 가장 작은 값, 트리가 비어있다면 null
   */
  E findMin();

  /**
   *  트리에서 가장 큰 값을 찾습니다.
   *
   * @return 트리에서 가장 큰 값, 트리가 비어있다면 null
   */
  E findMax();

  /**
   *  트리의 크기를 반환합니다.
   *
   * @return 트리의 총 노드의 개수
   */
  int size();

  /**
   *  트리가 비어있는지 확인합니다.
   *
   * @return 트리가 비어있으면 true, 아니면 false
   */
  boolean isEmpty();

  /**
   *  트리의 모든 요소를 중위 순회하여 문자열로 반환합니다.
   * (정렬된 순서로 반환)
   *
   * @return 중위 순회 결과를 문자열 형태로 반환
   */
  String inOrderTraversal();

  /**
   *  트리의 높이를 반환합니다.
   *
   * @return 트리의 높이
   */
  int height();
}
