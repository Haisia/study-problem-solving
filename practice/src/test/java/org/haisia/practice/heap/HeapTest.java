package org.haisia.practice.heap;

import org.haisia.practice.heap.question.Heap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
  private IHeap<Integer> heap;

  @BeforeEach
  void setUp() {
    // Heap 구현체 초기화 (구현체 이름은 실제 클래스에 맞게 수정)
    heap = new Heap<>(); // 예시: BinaryHeap 구현체
  }

  @Test
  void testInsertAndPeek() {
    // 힙에 값을 삽입
    heap.insert(10);
    heap.insert(20);
    heap.insert(5);

    // 힙의 루트 값 확인 (최소 힙이라고 가정. 최대 힙 테스트의 경우 예상값을 변경)
    assertEquals(5, heap.peek(), "Peek 메서드는 현재 최소값(또는 최대값)을 반환해야 합니다.");
  }

  @Test
  void testExtract() {
    // 힙에 값 삽입
    heap.insert(15);
    heap.insert(10);
    heap.insert(20);

    // 루트 요소 제거 및 반환 값 확인 (최소 힙 기준)
    assertEquals(10, heap.extract(), "Extract는 최소값(또는 최대값)을 반환해야 합니다.");
    assertEquals(15, heap.extract(), "두 번째 최소값(또는 최대값)을 반환해야 합니다.");
    assertEquals(20, heap.extract(), "마지막 요소를 반환해야 합니다.");

    // 힙이 비어 있을 때 extract() 호출 시 예외 처리 확인 또는 null 반환
    assertThrows(Exception.class, () -> heap.extract(), "빈 힙에서 Extract 호출 시 예외가 발생하거나 null을 반환해야 합니다.");
  }

  @Test
  void testIsEmpty() {
    // 초기 상태는 비어 있어야 함
    assertTrue(heap.isEmpty(), "초기 상태에서는 힙이 비어 있어야 합니다.");

    // 데이터 삽입 후 비어 있지 않아야 함
    heap.insert(1);
    assertFalse(heap.isEmpty(), "데이터 삽입 후 힙이 비어 있지 않아야 합니다.");

    // 데이터 제거 후 다시 비어 있어야 함
    heap.extract();
    assertTrue(heap.isEmpty(), "모든 데이터를 제거한 후 힙은 비어 있어야 합니다.");
  }

  @Test
  void testSize() {
    // 초기 크기 확인
    assertEquals(0, heap.size(), "초기 힙의 크기는 0이어야 합니다.");

    // 데이터 삽입 후 크기 확인
    heap.insert(10);
    heap.insert(20);
    assertEquals(2, heap.size(), "힙에 두 개의 요소를 추가한 후 크기는 2이어야 합니다.");

    // 데이터 제거 후 크기 확인
    heap.extract();
    assertEquals(1, heap.size(), "힙에서 요소 하나를 제거한 후 크기는 1이어야 합니다.");

    // 모든 데이터 제거 후 크기 확인
    heap.extract();
    assertEquals(0, heap.size(), "모든 요소를 제거한 후 크기는 0이어야 합니다.");
  }

  @Test
  void testHeapProperty() {
    // 여러 값을 힙에 삽입
    heap.insert(30);
    heap.insert(10);
    heap.insert(20);
    heap.insert(5);

    // 추출 순서 확인 (최소 힙 기준, 최대 힙이면 예상값 변경 필요)
    assertEquals(5, heap.extract(), "Extract는 최소값(또는 최대값)을 반환해야 합니다.");
    assertEquals(10, heap.extract(), "Extract는 다음 최소값(또는 최대값)을 반환해야 합니다.");
    assertEquals(20, heap.extract(), "Extract는 그 다음 최소값(또는 최대값)을 반환해야 합니다.");
    assertEquals(30, heap.extract(), "Extract는 마지막 값을 반환해야 합니다.");

    // 상태 확인
    assertTrue(heap.isEmpty(), "모든 요소를 제거한 후 힙은 비어 있어야 합니다.");
  }
}