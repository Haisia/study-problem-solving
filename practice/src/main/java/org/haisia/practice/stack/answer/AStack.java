package org.haisia.practice.stack.answer;

import org.haisia.practice.stack.IStack;

/**
 * test code :
 * @see org.haisia.practice.stack.question.StackTest
 */
public class AStack<E> implements IStack<E> {

  private Node<E> top;
  private int size;

  @Override
  public void push(E data) {
    if (data == null) return;

    if (top == null) {
      top = new Node<>(data, null);
    } else {
      top = new Node<>(data, top);
    }
    size++;
  }

  @Override
  public E pop() {
    if (size == 0) throw new RuntimeException();

    Node<E> target = top;
    changeTopToPrev();
    target.clearPrevLink();
    size--;

    return target.data;
  }

  @Override
  public E peek() {
    if (size == 0) throw new RuntimeException();

    return top.data;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private void changeTopToPrev() {
    top = top.prev;
  }

  public AStack() {
  }

  private static class Node<E> {
    E data;
    Node<E> prev;

    public Node(E data, Node<E> prev) {
      this.data = data;
      this.prev = prev;
    }

    public void clearPrevLink() {
      prev = null;
    }
  }
}
