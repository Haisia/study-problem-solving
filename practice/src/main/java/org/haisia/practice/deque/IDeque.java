package org.haisia.practice.deque;

public interface IDeque<E> {

  /**
   * 덱의 맨 앞에 요소를 추가합니다.
   *
   * @param element 추가할 요소
   */
  void addFirst(E element);

  /**
   * 덱의 맨 뒤에 요소를 추가합니다.
   *
   * @param element 추가할 요소
   */
  void addLast(E element);

  /**
   * 덱의 맨 앞 요소를 제거하고 반환합니다.
   *
   * @return 제거된 요소
   * @throws RuntimeException 덱이 비어있을 경우 예외 발생
   */
  E removeFirst();

  /**
   * 덱의 맨 뒤 요소를 제거하고 반환합니다.
   *
   * @return 제거된 요소
   * @throws RuntimeException 덱이 비어있을 경우 예외 발생
   */
  E removeLast();

  /**
   * 덱의 맨 앞 요소를 반환하지만 제거하지 않습니다.
   *
   * @return 덱의 맨 앞 요소
   * @throws RuntimeException 덱이 비어있을 경우 예외 발생
   */
  E peekFirst();

  /**
   * 덱의 맨 뒤 요소를 반환하지만 제거하지 않습니다.
   *
   * @return 덱의 맨 뒤 요소
   * @throws RuntimeException 덱이 비어있을 경우 예외 발생
   */
  E peekLast();

  /**
   * 덱이 비어있는지 확인합니다.
   *
   * @return 덱이 비어있으면 true, 아니면 false
   */
  boolean isEmpty();

  /**
   * 덱에 있는 요소의 개수를 반환합니다.
   *
   * @return 덱의 요소 개수
   */
  int size();

  /**
   * 덱의 모든 요소를 문자열 형태로 반환합니다.
   *
   * @return 덱의 내용을 문자열로 표현
   */
  @Override
  String toString();
}
