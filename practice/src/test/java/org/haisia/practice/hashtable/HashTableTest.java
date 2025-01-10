package org.haisia.practice.hashtable;

import org.haisia.practice.hashtable.answer.AHashTable;
import org.haisia.practice.hashtable.question.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

  private IHashTable<String, Integer> hashTable;

  @BeforeEach
  void setUp() {
    hashTable = new AHashTable<>();
  }

  @Test
  void testPutAndGet() {
    // 데이터 삽입
    hashTable.put("A", 1);
    hashTable.put("B", 2);
    hashTable.put("C", 3);

    // 데이터 조회
    assertEquals(1, hashTable.get("A"));
    assertEquals(2, hashTable.get("B"));
    assertEquals(3, hashTable.get("C"));

    // 존재하지 않는 키
    assertNull(hashTable.get("D"));

    // 기존 데이터 업데이트
    hashTable.put("A", 99);
    assertEquals(99, hashTable.get("A"), "키 A는 99로 업데이트되어야 합니다.");
  }

  @Test
  void testRemove() {
    // 데이터 삽입
    hashTable.put("A", 1);
    hashTable.put("B", 2);

    // 데이터 삭제
    assertEquals(1, hashTable.remove("A"), "키 A에 해당하는 값 1을 반환해야 합니다.");
    assertNull(hashTable.get("A"), "키 A는 삭제되었으므로 null을 반환해야 합니다.");
    assertNull(hashTable.remove("C"), "존재하지 않는 키를 삭제 시 null을 반환해야 합니다.");
  }

  @Test
  void testSize() {
    // 초기 크기 확인
    assertEquals(0, hashTable.size(), "초기 크기는 0이어야 합니다.");

    // 데이터 삽입 후 크기 확인
    hashTable.put("A", 1);
    hashTable.put("B", 2);
    assertEquals(2, hashTable.size(), "데이터 추가 후 크기는 2이어야 합니다.");

    // 데이터 삭제 후 크기 확인
    hashTable.remove("A");
    assertEquals(1, hashTable.size(), "데이터 삭제 후 크기는 1이어야 합니다.");
  }

  @Test
  void testContainsKey() {
    // 데이터 삽입
    hashTable.put("A", 1);
    hashTable.put("B", 2);

    // 키 존재 여부 확인
    assertTrue(hashTable.containsKey("A"));
    assertTrue(hashTable.containsKey("B"));
    assertFalse(hashTable.containsKey("C"));
  }

  @Test
  void testContainsValue() {
    // 데이터 삽입
    hashTable.put("A", 1);
    hashTable.put("B", 2);

    // 값 존재 여부 확인
    assertTrue(hashTable.containsValue(1));
    assertTrue(hashTable.containsValue(2));
    assertFalse(hashTable.containsValue(3));
  }

  @Test
  void testIsEmpty() {
    // 초기 상태 확인
    assertTrue(hashTable.isEmpty(), "초기에는 해시테이블이 비어 있어야 합니다.");

    // 데이터 삽입 후 확인
    hashTable.put("A", 1);
    assertFalse(hashTable.isEmpty(), "데이터 삽입 이후엔 해시테이블이 비어 있지 않아야 합니다.");

    // 모든 데이터 삭제 후 확인
    hashTable.remove("A");
    assertTrue(hashTable.isEmpty(), "데이터 삭제 후 해시테이블이 비어 있어야 합니다.");
  }

  @Test
  void testClear() {
    // 데이터 삽입
    hashTable.put("A", 1);
    hashTable.put("B", 2);

    // 초기 크기 확인
    assertEquals(2, hashTable.size(), "데이터 삽입 후 크기는 2이어야 합니다.");

    // 해시테이블 초기화
    hashTable.clear();

    // 초기화 이후 확인
    assertEquals(0, hashTable.size(), "clear() 호출 후 크기는 0이어야 합니다.");
    assertTrue(hashTable.isEmpty(), "clear() 호출 후 해시테이블이 비어 있어야 합니다.");
    assertFalse(hashTable.containsKey("A"), "clear() 호출 후 존재했던 키는 없어야 합니다.");
  }
}