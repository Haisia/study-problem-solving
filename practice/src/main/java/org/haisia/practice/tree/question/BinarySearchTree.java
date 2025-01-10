package org.haisia.practice.tree.question;


import org.haisia.practice.tree.ITree;

public class BinarySearchTree<E extends Comparable<E>> implements ITree<E> {
  @Override
  public boolean insert(E element) {
    return false;
  }

  @Override
  public boolean delete(E element) {
    return false;
  }

  @Override
  public boolean search(E element) {
    return false;
  }

  @Override
  public E findMin() {
    return null;
  }

  @Override
  public E findMax() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public String inOrderTraversal() {
    return "";
  }

  @Override
  public int height() {
    return 0;
  }
}
