# 916. 단어 부분집합 (Word Subsets)

## 문제 설명
두 개의 문자열 배열 `words1`과 `words2`가 주어집니다.

문자열 `b`가 문자열 `a`의 **부분집합**이라면, `b`에 있는 모든 문자가(중복 포함) `a`에도 포함되어 있는 경우를 의미합니다.

예를 들어:
- "wrr"은 "warrior"의 부분집합입니다.
- 하지만 "wrr"은 "world"의 부분집합이 아닙니다.

`words1`의 문자열 `a`가 **범용 문자열(universal)** 이라면, `words2`의 모든 문자열 `b`가 그 `a`의 부분집합이어야 합니다.

범용 문자열로 간주되는 문자열들을 배열로 반환하세요. 반환 순서는 상관없습니다.

---

## 예시

### 예시 1
**입력:**
- `words1 = ["amazon", "apple", "facebook", "google", "leetcode"]`
- `words2 = ["e", "o"]`

**출력:**
- `["facebook", "google", "leetcode"]`

---

### 예시 2
**입력:**
- `words1 = ["amazon", "apple", "facebook", "google", "leetcode"]`
- `words2 = ["l", "e"]`

**출력:**
- `["apple", "google", "leetcode"]`

---

## 제한 사항
1. `1 <= words1.length, words2.length <= 10⁴`
2. `1 <= words1[i].length, words2[i].length <= 10`
3. `words1[i]`와 `words2[i]`는 **소문자 영어 알파벳**으로만 이루어져 있습니다.
4. `words1`의 모든 문자열은 **고유**합니다.