package org.haisia.practice.queue;

public interface IQueue<E> {

  /**
   * 큐의 맨 뒤에 요소를 추가합니다.
   *
   * @param element 추가할 요소
   */
  void enqueue(E element);

  /**
   * 큐의 맨 앞에서 요소를 제거하고 반환합니다.
   *
   * @return 제거된 요소
   * @throws RuntimeException 큐가 비어있을 때 호출하면 예외 발생
   */
  E dequeue();

  /**
   * 큐의 맨 앞에 있는 요소를 반환하고 제거하지 않습니다.
   *
   * @return 큐의 맨 앞 요소
   * @throws RuntimeException 큐가 비어있을 때 호출하면 예외 발생
   */
  E peek();

  /**
   * 큐가 비어있는지 확인합니다.
   *
   * @return 비어있으면 true, 그렇지 않으면 false
   */
  boolean isEmpty();

  /**
   * 큐의 크기를 반환합니다.
   *
   * @return 큐에 있는 요소의 개수
   */
  int size();

  /**
   * 큐의 모든 요소를 문자열 형태로 반환합니다.
   *
   * @return 큐의 내용을 문자열로 표현
   */
  @Override
  String toString();
}
