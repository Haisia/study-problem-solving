package org.haisia.practice.queue;

import org.haisia.practice.queue.answer.AQueue;
import org.haisia.practice.queue.question.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IQueueTest {
  private IQueue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new AQueue<>();
  }

  @Test
  void testEnqueueAndSize() {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    assertEquals(3, queue.size()); // 큐에 3개의 요소가 있어야 함
  }

  @Test
  void testDequeue() {
    queue.enqueue(40);
    queue.enqueue(50);
    assertEquals(40, queue.dequeue()); // 큐에서 첫 번째로 추가된 요소 반환
    assertEquals(50, queue.peek()); // 다음 요소 확인
    assertEquals(1, queue.size()); // dequeue 후 크기 확인
  }

  @Test
  void testPeek() {
    queue.enqueue(60);
    queue.enqueue(70);
    assertEquals(60, queue.peek()); // 큐의 맨 앞 요소 확인
    assertEquals(2, queue.size()); // peek은 크기에 영향을 주지 않음
  }

  @Test
  void testIsEmpty() {
    assertTrue(queue.isEmpty()); // 초기 상태는 비어 있어야 함
    queue.enqueue(80);
    assertFalse(queue.isEmpty()); // enqueue 후에는 비어있지 않아야 함
    queue.dequeue();
    assertTrue(queue.isEmpty()); // 요소를 제거한 후 다시 비어 있어야 함
  }

  @Test
  void testDequeueFromEmptyQueue() {
    assertThrows(RuntimeException.class, queue::dequeue); // 빈 큐에서 dequeue 시 예외 발생
  }

  @Test
  void testPeekFromEmptyQueue() {
    assertThrows(RuntimeException.class, queue::peek); // 빈 큐에서 peek 시 예외 발생
  }

}