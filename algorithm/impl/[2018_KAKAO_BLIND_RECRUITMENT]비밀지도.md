# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17681)

### 비트 이동 연산자 활용

arr1과 arr2의 각각의 요소는 지도에서 행에 해당한다.

중요한 포인트는

```java
if ((cur1 & 1 << n - j - 1) != 0) map[i][j] = true;
```

이다.

이 코드를 통해 현재 cur1 행에서 각각의 열이 0인지 아닌지 알 수 있다.

0이 아니라면 지도에 true를 넣어 그 위치에 벽이 있다고 체크한다.

# [[풀이]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/solution_비밀지도.java)