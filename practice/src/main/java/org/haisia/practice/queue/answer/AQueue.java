package org.haisia.practice.queue.answer;

import org.haisia.practice.queue.IQueue;

/**
 * @see org.haisia.practice.queue.IQueueTest
 */
public class AQueue<E> implements IQueue<E> {

  // ( -> ..., data3, data2, data1 -> )
  // <- last ---------------- first ->
  private Node<E> first;
  private Node<E> last;
  private int size;

  @Override
  public void enqueue(E data) {
    if (data == null) throw new RuntimeException();
    Node<E> newNode = new Node<>(data, null);
    if (first == null) {
      first = newNode;
    } else {
      last.prev = newNode;
    }
    last = newNode;
    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) throw new RuntimeException();
    Node<E> target = first;
    first = first.prev;

    if (first == null) {
      last = null;
    }

    target.clearLink();
    size--;
    return target.data;
  }

  @Override
  public E peek() {
    if (isEmpty()) throw new RuntimeException();
    return first.data;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  public AQueue() {
  }

  private static class Node<E> {
    E data;
    // ( -> data1, data2, data3, ... -> )
    // <- prev ------------------ next ->
    Node<E> prev;

    public Node(E data, Node<E> prev) {
      this.data = data;
      this.prev = prev;
    }

    public void clearLink() {
      prev = null;
    }
  }

}
