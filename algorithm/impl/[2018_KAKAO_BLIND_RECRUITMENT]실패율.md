# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/42889)

## 🚩 주요 키워드

-   Stage 클래스를 만들어서 구현하였다.
-   Comparable을 이용해 실패율에 따라 내림차순하고, 실패율이 같다면 스테이지 순으로 오름차순한다.

```java
public int compareTo(Stage o) {
    int result = Float.compare(o.getFailureRate(), getFailureRate());
    return result == 0 ? num - o.num : result;
}
```

-   Stage 클래스의 배열을 만들어서 모든 스테이지에 대한 정보를 담아뒀는데, 인덱스가 0일 때와 N + 1일 경우를 관리해주어야 한다.

```java
for (int i = 0; i < N + 2; i++) {
    if (array[i].num == 0 || array[i].num == N + 1) continue;
    list.add(array[i].num);
}
```

-   arrivalCount가 0일 경우에는 실패율을 0으로 만들어준다.

```java
private float getFailureRate() {
    if (arrivalCount == 0) return 0;
    return (float) failureCount / arrivalCount;
}
```

## 🔑 풀이

-   Stage 클래스의 배열을 총 N+2 길이만큼 만든다.
-   파라미터로 받은 stage값보다 작거나 같은 인덱스는 arrivalCount를 1 늘려준다.
-   failureCount는 stage값과 같은 인덱스만 늘려준다.
-   그 후 `Arrays.sort()`를 이용하면 실패율에 따라 정렬이 된다.
-   그리고 answer에 대입하면 되는데, 이 때 num이 0일 경우와 N+1일 경우는 제외한다. (0은 padding값이고, n+1은 실제 존재하는 스테이지가 아니다.)

## 후기

실수가 많아서 디버깅을 많이 했어야 했다. 너무 아쉬운 문제였다. ㅠ

# [[전체 코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_실패율.java)
