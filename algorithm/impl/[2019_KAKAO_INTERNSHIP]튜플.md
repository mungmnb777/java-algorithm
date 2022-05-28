# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/64065)

# 🚩 주요 키워드

---

- 열심히 구현

## 🔑 풀이

---

초기화 작업이랑 결과 도출 작업으로 나눔

- 초기화 작업
  1. 먼저 가장 자리의 중괄호를 하나씩 없앰 → `s == “{2},{2,1},{2,1,3},{2,1,3,4}”`
  2. 각각의 중괄호 내부 문자열을 파싱함 → 문자열을 콤마 단위로 끊어서 정수 리스트로 만든 다음 `list`에 저장 → `parse()` 메서드
  ```java
  private static void parse(String element) {
      list.add(Arrays.stream(element.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
  }
  ```
  1. `list`를 원소 리스트의 길이를 오름차순으로 정렬
  ```java
  list.sort(Comparator.comparingInt(List::size));
  ```
- 결과 도출 작업
  1. 이중 for문을 통해 완전 탐색한다. 탐색한 정수가 result에 있는 값과 중복되면 값을 넣지 않는다. → 초기화 때 리스트의 길이대로 정렬했기 때문에 중복체크만 하면 튜플이 뭔지 알 수 있음

## 후기

---

간단한 구현 문제

# [[전체 코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_튜플.java)
