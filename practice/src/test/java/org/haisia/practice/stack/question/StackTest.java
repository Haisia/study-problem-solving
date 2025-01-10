package org.haisia.practice.stack.question;

import org.haisia.practice.stack.IStack;
import org.haisia.practice.stack.answer.AStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  private IStack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new AStack<>();
  }

  @Test
  void testPushAndPeek() {
    stack.push(10);
    stack.push(20);
    assertEquals(20, stack.peek()); // 마지막으로 추가된 값이 top이어야 함
    assertEquals(2, stack.size()); // 스택의 크기 확인
  }

  @Test
  void testPop() {
    stack.push(30);
    stack.push(40);
    assertEquals(40, stack.pop()); // pop은 가장 마지막 값을 반환
    assertEquals(30, stack.peek()); // pop 이후 top 값 확인
    assertEquals(1, stack.size()); // pop 이후 크기 확인
  }

  @Test
  void testIsEmpty() {
    assertTrue(stack.isEmpty()); // 초기 상태는 비어 있어야 함
    stack.push(50);
    assertFalse(stack.isEmpty()); // push 후에는 비어 있지 않음
    stack.pop();
    assertTrue(stack.isEmpty()); // 모든 요소를 pop하면 비어 있어야 함
  }

  @Test
  void testSize() {
    assertEquals(0, stack.size()); // 초기 상태에서 크기는 0
    stack.push(60);
    stack.push(70);
    assertEquals(2, stack.size()); // 요소 2개 추가 후 크기 확인
    stack.pop();
    assertEquals(1, stack.size()); // pop 이후 크기 확인
  }

  @Test
  void testPopOnEmptyStack() {
    assertThrows(RuntimeException.class, stack::pop); // 비어 있는 스택에서 pop 시 예외 발생
  }

  @Test
  void testPeekOnEmptyStack() {
    assertThrows(RuntimeException.class, stack::peek); // 비어 있는 스택에서 peek 시 예외 발생
  }

}