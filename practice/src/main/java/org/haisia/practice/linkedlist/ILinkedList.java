package org.haisia.practice.linkedlist;

// LinkedList 인터페이스
public interface ILinkedList<E> {

  // 리스트의 맨 앞에 요소 추가
  void addFirst(E element);

  // 리스트의 맨 뒤에 요소 추가
  void addLast(E element);

  // 특정 위치에 요소 추가
  void add(int index, E element);

  // 리스트의 맨 앞의 요소 제거
  E removeFirst();

  // 리스트의 맨 뒤의 요소 제거
  E removeLast();

  // 특정 위치의 요소 제거
  E remove(int index);

  // 리스트의 맨 앞의 요소 반환 (제거하지 않음)
  E getFirst();

  // 리스트의 맨 뒤의 요소 반환 (제거하지 않음)
  E getLast();

  // 특정 인덱스의 요소 반환 (제거하지 않음)
  E get(int index);

  // 리스트의 크기(요소 개수) 반환
  int size();

  // 리스트가 비어 있는지 확인
  boolean isEmpty();

  // 리스트의 모든 요소를 문자열로 반환
  String toString();
}
