# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/92342)

## 🚩 주요 키워드

---

-   조합
-   조건 분기를 잘 짜야함

## 🔑 풀이

---

-   중복을 허용한 조합을 사용함
-   조건이 많기 때문에 조건을 잘 짜는게 중요함

```java
// 어피치가 이기거나 지는 경우는 바로 리턴
if (diff <= 0) return;

// diff가 maxDiff보다 작은 경우 리턴
if (diff < maxDiff) return;

// diff가 maxDiff와 같은 경우 -> 가장 낮은 점수를 더 많이 맞힌 경우를 리턴해야함
if (diff == maxDiff) {
    for (int i = 10; i >= 0; i--) {
				// answer가 가장 낮은 점수를 더 많이 맞히면 값 변경을 하면 안되므로 바로 return
        if (answer[i] > ryan[i]) return;
				// ryan이 더 많이 맞히면 반복문 탈출 후 값 변경
        else if (answer[i] < ryan[i]) break;
    }
}
```

## 후기

---

조건 짜는게 어려운 문제였다

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_양궁대회.java)
