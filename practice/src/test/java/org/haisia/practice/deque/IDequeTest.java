package org.haisia.practice.deque;

import org.haisia.practice.deque.answer.ADeque;
import org.haisia.practice.deque.question.Deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDequeTest {
  private IDeque<Integer> deque;

  @BeforeEach
  void setUp() {
    deque = new ADeque<>();
  }

  @Test
  void testAddFirst() {
    deque.addFirst(10);
    deque.addFirst(20);
    deque.addFirst(30);
    assertEquals(3, deque.size()); // 추가한 요소 수와 크기가 맞는지 확인
  }

  @Test
  void testAddLast() {
    deque.addLast(10);
    deque.addLast(20);
    deque.addLast(30);
    assertEquals(3, deque.size()); // 크기 확인
  }

  @Test
  void testRemoveFirst() {
    deque.addLast(40);
    deque.addLast(50);
    deque.addLast(60);
    assertEquals(40, deque.removeFirst()); // 맨 앞 요소 제거
    assertEquals(50, deque.peekFirst()); // 제거 후 맨 앞 요소 확인
    assertEquals(2, deque.size()); // 크기 확인
  }

  @Test
  void testRemoveLast() {
    deque.addFirst(70);
    deque.addFirst(80);
    deque.addFirst(90);
    assertEquals(70, deque.removeLast()); // 맨 뒤 요소 제거
    assertEquals(80, deque.peekLast()); // 제거 후 맨 뒤 요소 확인
    assertEquals(2, deque.size()); // 크기 확인
  }

  @Test
  void testPeekFirst() {
    deque.addLast(100);
    deque.addLast(110);
    assertEquals(100, deque.peekFirst()); // 맨 앞 요소 확인
    assertEquals(2, deque.size()); // peek은 크기를 변화시키지 않음
  }

  @Test
  void testPeekLast() {
    deque.addFirst(120);
    deque.addFirst(130);
    assertEquals(120, deque.peekLast()); // 맨 뒤 요소 확인
    assertEquals(2, deque.size()); // peek은 크기를 변화시키지 않음
  }

  @Test
  void testIsEmpty() {
    assertTrue(deque.isEmpty()); // 초기 상태에서 덱은 비어 있어야 함
    deque.addFirst(150);
    assertFalse(deque.isEmpty()); // 요소가 추가되면 비어있지 않아야 함
    deque.removeFirst();
    assertTrue(deque.isEmpty()); // 모든 요소가 제거된 후 다시 비어 있어야 함
  }

  @Test
  void testSize() {
    assertEquals(0, deque.size()); // 초기 크기는 0이어야 함
    deque.addLast(160);
    deque.addFirst(170);
    assertEquals(2, deque.size()); // 요소가 추가된 후 정확한 크기 확인
    deque.removeLast();
    assertEquals(1, deque.size()); // 제거 후 크기 확인
  }

  @Test
  void testRemoveFromEmptyDeque() {
    assertThrows(RuntimeException.class, deque::removeFirst); // 빈 덱에서 removeFirst 호출 시 예외 발생
    assertThrows(RuntimeException.class, deque::removeLast);  // 빈 덱에서 removeLast 호출 시 예외 발생
  }

  @Test
  void testPeekOnEmptyDeque() {
    assertThrows(RuntimeException.class, deque::peekFirst); // 빈 덱에서 peekFirst 호출 시 예외 발생
    assertThrows(RuntimeException.class, deque::peekLast);  // 빈 덱에서 peekLast 호출 시 예외 발생
  }
}