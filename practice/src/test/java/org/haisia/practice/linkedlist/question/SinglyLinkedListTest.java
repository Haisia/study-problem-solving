package org.haisia.practice.linkedlist.question;

import org.haisia.practice.linkedlist.ILinkedList;
import org.haisia.practice.linkedlist.answer.ASinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

  private ILinkedList<Integer> linkedList;

  @BeforeEach
  void setUp() {
    linkedList = new ASinglyLinkedList<>();
  }

  @Test
  void testAddFirst() {
    linkedList.addFirst(10);
    linkedList.addFirst(20);
    assertEquals(20, linkedList.getFirst());
    assertEquals(2, linkedList.size());
  }

  @Test
  void testAddLast() {
    linkedList.addLast(30);
    linkedList.addLast(40);
    assertEquals(30, linkedList.getFirst());
    assertEquals(40, linkedList.getLast());
    assertEquals(2, linkedList.size());
  }

  @Test
  void testAddAtIndex() {
    linkedList.addLast(50);
    linkedList.addLast(60);
    linkedList.add(1, 55); // [50, 55, 60]

    assertEquals(55, linkedList.get(1));
    assertEquals(3, linkedList.size());
  }

  @Test
  void testRemoveFirst() {
    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);

    assertEquals(10, linkedList.removeFirst());
    assertEquals(20, linkedList.getFirst());
    assertEquals(2, linkedList.size());
  }

  @Test
  void testRemoveLast() {
    linkedList.addLast(40);
    linkedList.addLast(50);
    linkedList.addLast(60);

    assertEquals(60, linkedList.removeLast());
    assertEquals(50, linkedList.getLast());
    assertEquals(2, linkedList.size());
  }

  @Test
  void testRemoveAtIndex() {
    linkedList.addLast(70);
    linkedList.addLast(80);
    linkedList.addLast(90);

    assertEquals(80, linkedList.remove(1)); // [70, 90]
    assertEquals(90, linkedList.get(1));
    assertEquals(2, linkedList.size());
  }

  @Test
  void testGetFirstAndLast() {
    linkedList.addLast(100);
    linkedList.addLast(110);

    assertEquals(100, linkedList.getFirst());
    assertEquals(110, linkedList.getLast());
  }

  @Test
  void testIsEmpty() {
    assertTrue(linkedList.isEmpty());
    linkedList.addLast(120);
    assertFalse(linkedList.isEmpty());
  }

  @Test
  void testSize() {
    assertEquals(0, linkedList.size());
    linkedList.addLast(10);
    linkedList.addLast(20);
    assertEquals(2, linkedList.size());
  }

}