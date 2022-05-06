# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/81302)

## 🚩 주요 키워드

---

-   BFS

## 🔑 풀이

---

P의 위치를 기준으로 BFS를 돌렸다.

BFS의 깊이가 증가할 때마다 manhattan 변수의 숫자를 1 늘려주고, 변수가 2를 초과하면 거리두기를 지키고 있는 것이다.

BFS 작업 도중 P를 만나게 되면 거리두기를 지키지 못하는 것이므로 0을 리턴한다.

## 후기

---

오랜만의 BFS라 시간이 조금 걸렸다.

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_거리두기확인하기.java)
