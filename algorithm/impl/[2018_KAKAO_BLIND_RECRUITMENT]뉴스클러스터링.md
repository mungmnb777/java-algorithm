# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17677)

## 🚩 주요 키워드

- 자바 Collection API와 String API를 활용해서 단순하게 구현하였음
- 주요 메서드
    - 문자열을 길이 2인 문자로 나누기 위한 `addSet()` 메서드
        
        ```java
        private static void addSet(String str, List<String> set) {
          int length = str.length() - 1;
        
          for (int i = 0; i < length; i++) {
              // 둘 다 알파벳인 경우에만 실행
              if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                  // 길이 2의 문자열로 나누어서 집합에 저장
                  String s = "" + str.charAt(i) + str.charAt(i + 1);
                  set.add(s);
              }
          }
        }
        ```
        
    - 교집합
        
        ```java
        // stringSet2의 문자열을 stringSet1과 비교
        for (int i = 0; i < stringSet2.size(); i++) {
            String cur = stringSet2.get(i);
            // 만약 cur 문자열이 stringSet1에 있으면
            if (stringSet1.contains(cur)) {
                stringSet1.remove(cur);
                intersect.add(cur);
            }
        }
        ```
        

## 🔑 풀이

1. 대소문자를 구별하지 않는다고 했으므로 전부 소문자로 통일

```java
// 대소문자 구분을 하지 않으므로 소문자로 통일한다.
str1 = str1.toLowerCase();
str2 = str2.toLowerCase();
```

1. 큰 문자열을 길이 두 글자씩 나누어 저장한 리스트 2개

```java
// 2글자씩 나눈 문자열을 저장할 List Collection
List<String> stringSet1 = new ArrayList<>();
List<String> stringSet2 = new ArrayList<>();
// 문자열을 2글자씩 나누는 메서드
addSet(str1, stringSet1);
addSet(str2, stringSet2);
```

1. 합집합 및 교집합

```java
// 합집합이 들어갈 리스트
List<String> union = new ArrayList<>();
// 리스트에 있는 문자열 전부 저장
union.addAll(stringSet1);
union.addAll(stringSet2);

// 교집합이 들어갈 리스트 
List<String> intersect = new ArrayList<>();

// stringSet2의 문자열을 stringSet1과 비교
for (int i = 0; i < stringSet2.size(); i++) {
    String cur = stringSet2.get(i);
    // 만약 cur 문자열이 stringSet1에 있으면
    if (stringSet1.contains(cur)) {
        stringSet1.remove(cur);
        intersect.add(cur);
    }
}

// 전체 집합과 교집합을 빼면 합집합.
for (String s : intersect) {
    union.remove(s);
}
```

→ 사실 교집합 구하는 메서드는 더 쉬운 방법이 있을 것 같은데 좀처럼 생각이 나지 않아 가장 직관적인 방법으로 했다 (겹치는 문자열이 있으면 리스트에서 없애주고 교집합에 넣어주기)

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_뉴스클러스터링.java)