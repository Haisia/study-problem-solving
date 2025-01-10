package org.haisia.practice.linkedlist.answer;

import org.haisia.practice.linkedlist.ILinkedList;

public class ADoublyLinkedList<E> implements ILinkedList<E> {

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

  @Override
  public E get(int index) {
    return getNode(index).data;
  }

  private Node<E> getNode(int index) {
    validIndex(index);

    Node<E> target = first;
    int i = 0;
    while (i != index) {
      target = target.next;
      i++;
    }
    return target;
  }


  @Override
  public void addFirst(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()){
      first = newNode;
      last = newNode;
      size++;
      return;
    }

    newNode.next = first;
    first.prev = newNode;
    first = newNode;

    if (isEmpty()) {
      last = newNode;
    }

    size++;
  }

  @Override
  public void addLast(E data) {
    Node<E> newNode = new Node<>(data);
    if (isEmpty()){
      first = newNode;
      last = newNode;
      size++;
      return;
    }

    newNode.prev = last;
    last.next = newNode;
    last = newNode;

    if (isEmpty()) {
      first = newNode;
    }

    size++;
  }

  @Override
  public void add(int index, E data) {
    validIndex(index);
    Node<E> next = getNode(index);
    Node<E> prev = next.prev;
    Node<E> newNode = new Node<>(data);

    if (prev != null) {
      prev.next = newNode;
    }

    next.prev = newNode;
    newNode.prev = prev;
    newNode.next = next;
    size++;
  }

  @Override
  public E removeFirst() {
    if (isEmpty()) throw new RuntimeException();
    Node<E> target = first;
    Node<E> next = first.next;
    if (next != null) next.prev = null;
    first = next;

    target.prev = null;
    target.next = null;
    size--;
    return target.data;
  }

  @Override
  public E removeLast() {
    if (isEmpty()) throw new RuntimeException();
    Node<E> target = last;
    Node<E> prev = last.prev;
    if (prev != null) prev.next = null;
    last = prev;

    target.prev = null;
    target.next = null;
    size--;
    return target.data;
  }

  @Override
  public E remove(int index) {
    validIndex(index);

    Node<E> target = getNode(index);
    Node<E> prev = target.prev;
    Node<E> next = target.next;

    if (prev != null) {
      prev.next = next;
    }

    if (next != null) {
      next.prev = prev;
    }

    target.prev = null;
    target.next = null;
    size--;
    return target.data;
  }

  @Override
  public E getFirst() {
    if (first == null) throw new RuntimeException();
    return first.data;
  }

  @Override
  public E getLast() {
    if (last == null) throw new RuntimeException();
    return last.data;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private void validIndex(int index) {
    if (index < 0) throw new RuntimeException();
    if (index >= size) throw new RuntimeException();
  }
}
