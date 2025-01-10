package org.haisia.practice.hashtable.answer;

import org.haisia.practice.hashtable.IHashTable;

import java.util.ArrayList;
import java.util.List;

public class AHashTable<K,V> implements IHashTable<K,V> {

  private final static int INITIAL_CAPACITY = 10;
  private final List<List<Node<K,V>>> buckets;
  private int size;

  public AHashTable() {
    buckets = new ArrayList<>();
    for (int i = 0; i < INITIAL_CAPACITY; i++) {
      buckets.add(new ArrayList<>());
    }
  }

  private static class Node<K, V> {
    K key;
    V value;

    public Node(K key, V value) {
      if (key == null) throw new RuntimeException();

      this.key = key;
      this.value = value;
    }
  }

  @Override
  public void put(K key, V value) {
    int hash = getHash(key);
    List<Node<K, V>> findBucket = buckets.get(hash);

    for (Node<K, V> node : findBucket) {
      if (node.key.equals(key)) {
        node.value = value;
        return;
      }
    }

    buckets.get(hash).add(new Node<>(key, value));
    size++;
  }

  public int getHash(K key) {
    return key.hashCode() % INITIAL_CAPACITY;
  }

  @Override
  public V get(K key) {
    Node<K, V> node = findNode(key);
    return node != null ? node.value : null;
  }

  private Node<K,V> findNode(K key) {
    int hash = getHash(key);
    List<Node<K, V>> bucket = buckets.get(hash);
    for (Node<K, V> node : bucket) {
      if (node.key.equals(key)) return node;
    }
    return null;
  }

  @Override
  public V remove(K key) {
    Node<K, V> node = findNode(key);
    if (node == null) return null;

    int hash = getHash(key);
    List<Node<K, V>> bucket = buckets.get(hash);
    bucket.remove(node);
    size--;
    return node.value;
  }

  @Override
  public boolean containsKey(K key) {
    return get(key) != null;
  }

  @Override
  public boolean containsValue(V value) {
    for (List<Node<K, V>> bucket : buckets) {
      if(bucket.stream().anyMatch(n->n.value == value)) return true;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    buckets.forEach(List::clear);
    size = 0;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
