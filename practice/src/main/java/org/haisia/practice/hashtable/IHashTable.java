package org.haisia.practice.hashtable;

public interface IHashTable<K, V> {
  /**
   * 지정된 키와 값을 해시테이블에 추가합니다.
   * 만약 키가 이미 존재한다면 기존 값을 새 값으로 대체합니다.
   *
   * @param key   키
   * @param value 값
   */
  void put(K key, V value);

  /**
   * 지정된 키와 매핑된 값을 반환합니다.
   * 만약 키가 존재하지 않을 경우 null을 반환합니다.
   *
   * @param key 키
   * @return 매핑된 값 또는 null
   */
  V get(K key);

  /**
   * 지정된 키에 매핑된 키-값 쌍을 제거합니다.
   * 제거된 값(삭제 전 값)을 반환하며, 키가 없으면 null을 반환합니다.
   *
   * @param key 키
   * @return 삭제된 값 또는 null
   */
  V remove(K key);

  /**
   * 해시테이블에 지정된 키가 포함되어 있는지 확인합니다.
   *
   * @param key 키
   * @return 키가 포함되어 있으면 true, 그렇지 않으면 false
   */
  boolean containsKey(K key);

  /**
   * 해시테이블에 지정된 값이 포함되어 있는지 확인합니다.
   *
   * @param value 값
   * @return 값이 포함되어 있으면 true, 그렇지 않으면 false
   */
  boolean containsValue(V value);

  /**
   * 해시테이블의 현재 키-값 쌍의 개수를 반환합니다.
   *
   * @return 키-값 쌍의 개수
   */
  int size();

  /**
   * 해시테이블에 저장된 모든 항목을 제거합니다.
   */
  void clear();

  /**
   * 해시테이블이 비어 있는지 확인합니다.
   *
   * @return 비어 있으면 true, 그렇지 않으면 false
   */
  boolean isEmpty();
}
