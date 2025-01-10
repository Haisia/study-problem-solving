package org.haisia.practice.stack;

// Stack 인터페이스
public interface IStack<E> {

  /**
   * 스택의 맨 위에 요소 추가
   *
   * @param element 추가할 요소
   */
  void push(E element);

  /**
   * 스택의 맨 위에 있는 요소 제거 및 반환
   *
   * @return 제거된 요소
   */
  E pop();

  /**
   * 스택의 맨 위에 있는 요소 반환 (제거하지 않음)
   *
   * @return 스택의 맨 위 요소
   */
  E peek();

  /**
   * 스택의 크기 (요소 개수) 반환
   *
   * @return 현재 스택의 크기
   */
  int size();

  /**
   * 스택이 비어 있는지 확인
   *
   * @return 비어 있으면 true, 아니면 false
   */
  boolean isEmpty();

  /**
   * 스택의 모든 요소를 문자열로 반환
   *
   * @return 스택의 내용을 문자열로 표현
   */
  @Override
  String toString();
}