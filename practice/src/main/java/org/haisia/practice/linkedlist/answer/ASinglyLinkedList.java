package org.haisia.practice.linkedlist.answer;

import org.haisia.practice.linkedlist.ILinkedList;

public class ASinglyLinkedList<E> implements ILinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  @Override
  public void addFirst(E data) {
    first = new Node<>(data, first);
    if (isEmpty()) {
      last = first;
    }
    size++;
  }

  @Override
  public void addLast(E data) {
    if (isEmpty()) {
      addFirst(data);
      return;
    }
    Node<E> newNode = new Node<>(data, null);
    last.next = newNode;
    last = newNode;
    size++;
  }

  @Override
  public void add(int index, E data) {
    if (index < 0 || index > size) {
      throw new RuntimeException();
    }

    if (index == 0) {
      addFirst(data);
      return;
    } else if (index == size) {
      addLast(data);
      return;
    }

    Node<E> target = getNode(index - 1);
    target.next = new Node<>(data, target.next);
    size++;
  }

  @Override
  public E get(int index) {
    return getNode(index).data;
  }

  private Node<E> getNode(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException();
    }

    int i = 0;
    Node<E> current = first;
    while (i < index) {
      current = current.next;
      i++;
    }
    return current;
  }

  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new RuntimeException();
    }

    Node<E> target = first;
    first = first.next;

    if (size == 1) {
      last = null;
    }

    target.disconnect();
    size--;
    return target.data;
  }

  @Override
  public E removeLast() {
    if (isEmpty()) throw new RuntimeException();

    if (size == 1) {
      return removeFirst();
    }

    Node<E> current = first;
    while (current.next != last) {
      current = current.next;
    }

    Node<E> target = last;
    last = current;
    last.disconnect();
    size--;

    return target.data;
  }

  @Override
  public E remove(int index) {
    if (index == 0) return removeFirst();
    if (index == size - 1) return removeLast();

    Node<E> previous = getNode(index - 1);
    Node<E> target = previous.next;
    previous.next = target.next;

    target.disconnect();
    size--;
    return target.data;
  }

  @Override
  public E getFirst() {
    if (isEmpty()) throw new RuntimeException();
    return first.data;
  }

  @Override
  public E getLast() {
    if (isEmpty()) throw new RuntimeException();
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

  private static class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
      if (data == null) {
        throw new RuntimeException();
      }
      this.data = data;
      this.next = next;
    }

    public void disconnect() {
      next = null;
    }
  }
}
