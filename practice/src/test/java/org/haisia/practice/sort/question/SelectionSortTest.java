package org.haisia.practice.sort.question;

import org.haisia.practice.sort.ISort;
import org.haisia.practice.sort.answer.AInsertSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

  @Test
  void testSortWithIntegerArray() {
    ISort<Integer> insertSort = new AInsertSort<>();

    // 테스트 배열
    Integer[] input = {5, 3, 8, 1, 2};
    Integer[] expected = {1, 2, 3, 5, 8};

    // 정렬 수행
    Integer[] result = insertSort.sort(input);

    // 결과 검증
    assertArrayEquals(expected, result, "Integer 배열이 올바르게 정렬되지 않았습니다.");
  }

  @Test
  void testSortWithStringArray() {
    ISort<String> insertSort = new AInsertSort<>();

    // 테스트 배열
    String[] input = {"banana", "apple", "orange", "grape"};
    String[] expected = {"apple", "banana", "grape", "orange"};

    // 정렬 수행
    String[] result = insertSort.sort(input);

    // 결과 검증
    assertArrayEquals(expected, result, "String 배열이 올바르게 정렬되지 않았습니다.");
  }

  @Test
  void testSortWithEmptyArray() {
    ISort<Double> insertSort = new AInsertSort<>();

    // 빈 배열 테스트
    Double[] input = {};
    Double[] expected = {};

    // 정렬 수행
    Double[] result = insertSort.sort(input);

    // 결과 검증
    assertArrayEquals(expected, result, "빈 배열이 올바르게 처리되지 않았습니다.");
  }

  @Test
  void testSortWithSingleElementArray() {
    ISort<Character> insertSort = new AInsertSort<>();

    // 요소가 하나뿐인 배열 테스트
    Character[] input = {'a'};
    Character[] expected = {'a'};

    // 정렬 수행
    Character[] result = insertSort.sort(input);

    // 결과 검증
    assertArrayEquals(expected, result, "요소가 하나뿐인 배열이 올바르게 처리되지 않았습니다.");
  }

  @Test
  void testSortWithAlreadySortedArray() {
    ISort<Integer> insertSort = new AInsertSort<>();


    // 이미 정렬된 배열 테스트
    Integer[] input = {1, 2, 3, 4, 5};
    Integer[] expected = {1, 2, 3, 4, 5};

    // 정렬 수행
    Integer[] result = insertSort.sort(input);

    // 결과 검증
    assertArrayEquals(expected, result, "이미 정렬된 배열이 올바르게 처리되지 않았습니다.");
  }
}