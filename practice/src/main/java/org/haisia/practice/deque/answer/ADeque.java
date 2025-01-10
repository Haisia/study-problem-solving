package org.haisia.practice.deque.answer;

import org.haisia.practice.deque.IDeque;

public class ADeque<E> implements IDeque<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  private static class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data) {
      this.data = data;
    }
  }

  private void addWhenEmpty(E data) {
    Node<E> newData = new Node<>(data);
    first = newData;
    last = newData;
    size++;
  }

  private Node<E> removeWhenSizeOne() {
    Node<E> target = first;
    target.prev = null;
    target.next = null;
    first = null;
    last = null;
    size--;
    return target;
  }

  @Override
  public void addFirst(E data) {
    if (isEmpty()) {
      addWhenEmpty(data);
      return;
    }

    Node<E> newNode = new Node<>(data);
    newNode.next = first;
    first.prev = newNode;
    first = newNode;
    size++;
  }

  @Override
  public void addLast(E data) {
    if (isEmpty()) {
      addWhenEmpty(data);
      return;
    }

    Node<E> newNode = new Node<>(data);
    newNode.prev = last;
    last.next = newNode;
    last = newNode;
    size++;
  }

  @Override
  public E removeFirst() {
    if (size == 1) {
      return removeWhenSizeOne().data;
    }

    Node<E> target = first;
    Node<E> next = target.next;
    next.prev = null;
    first = next;
    target.prev = null;
    target.next = null;
    size--;
    return target.data;
  }

  @Override
  public E removeLast() {
    if (size == 1) {
      return removeWhenSizeOne().data;
    }

    Node<E> target = last;
    Node<E> prev = target.prev;
    prev.next = null;
    last = prev;
    target.prev = null;
    target.next = null;
    size--;
    return target.data;
  }

  @Override
  public E peekFirst() {
    if (size < 1) throw new RuntimeException();
    return first.data;
  }

  @Override
  public E peekLast() {
    if (size < 1) throw new RuntimeException();
    return last.data;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return size;
  }
}
