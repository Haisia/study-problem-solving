package org.haisia.practice.tree;

import org.haisia.practice.tree.question.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 클래스: 이진 탐색 트리에 대해 다양한 동작을 테스트합니다.
 */
public class BinarySearchTreeTest {

  private ITree<Integer> tree;

  @BeforeEach
  void setUp() {
    tree = new BinarySearchTree<>();
  }

  @Test
  void testInsertAndSearch() {
    assertTrue(tree.insert(10)); // 새로운 값 10 추가
    assertTrue(tree.insert(5));  // 새로운 값 5 추가
    assertTrue(tree.insert(15)); // 새로운 값 15 추가

    assertFalse(tree.insert(10)); // 중복된 값 10 추가 시도 -> 실패해야 함

    // 트리에서 값들 검색
    assertTrue(tree.search(10));
    assertTrue(tree.search(5));
    assertTrue(tree.search(15));
    assertFalse(tree.search(20)); // 존재하지 않는 값
  }

  @Test
  void testDelete() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);

    assertTrue(tree.delete(10)); // 루트 노드 삭제
    assertFalse(tree.search(10)); // 삭제 후 검색 -> false
    assertTrue(tree.search(5));  // 다른 값은 여전히 검색 가능
    assertTrue(tree.search(15));

    assertFalse(tree.delete(20)); // 존재하지 않는 값 삭제 -> false
  }

  @Test
  void testFindMinAndFindMax() {
    tree.insert(20);
    tree.insert(10);
    tree.insert(30);
    tree.insert(5);
    tree.insert(15);

    assertEquals(5, tree.findMin()); // 최솟값
    assertEquals(30, tree.findMax()); // 최댓값

    tree.delete(5); // 최솟값 삭제
    assertEquals(10, tree.findMin());

    tree.delete(30); // 최댓값 삭제
    assertEquals(20, tree.findMax());
  }

  @Test
  void testSize() {
    assertEquals(0, tree.size()); // 초기 트리 크기

    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    assertEquals(3, tree.size()); // 세 개의 노드를 추가한 후

    tree.delete(5);
    assertEquals(2, tree.size()); // 한 개의 노드를 삭제한 후
  }

  @Test
  void testIsEmpty() {
    assertTrue(tree.isEmpty()); // 초기 상태: 비어 있음

    tree.insert(10);
    assertFalse(tree.isEmpty()); // 값 삽입 후: 비어 있지 않음

    tree.delete(10);
    assertTrue(tree.isEmpty()); // 값 삭제 후: 비어 있음
  }

  @Test
  void testInOrderTraversal() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);

    assertEquals("[3, 5, 10, 15]", tree.inOrderTraversal()); // 중위 순회로 정렬된 결과 확인

    tree.delete(5);
    assertEquals("[3, 10, 15]", tree.inOrderTraversal());
  }

  @Test
  void testHeight() {
    assertEquals(-1, tree.height()); // 초기 비어 있는 트리의 높이는 -1로 간주

    tree.insert(10);
    assertEquals(0, tree.height()); // 하나의 노드가 있는 트리의 높이

    tree.insert(5);
    tree.insert(15);
    assertEquals(1, tree.height()); // 두 개의 레벨이 있는 트리의 높이

    tree.insert(3);
    assertEquals(2, tree.height()); // 세 개의 레벨이 있는 트리의 높이
  }
}