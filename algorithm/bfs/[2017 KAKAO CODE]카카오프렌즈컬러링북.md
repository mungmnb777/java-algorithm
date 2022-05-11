# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/1829)

## 🚩 주요 키워드

---

-   BFS

## 🔑 풀이

---

-   이차원 배열의 모든 원소에 대해 다음 조건을 만족하면 그 위치를 시작점으로 하여 BFS를 돌린다.
    -   이전 BFS를 통해 방문한 위치가 아닐 것
    -   현재 위치의 picture 값이 0이 아닐 것
    ```java
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (visit[i][j]) continue;
            if (picture[i][j] == 0) continue;

            bfs(i, j, m, n, picture);
            numberOfArea++;
        }
    }
    ```
-   BFS에서 다음 위치를 큐를 넣는 조건은 다음과 같다.
    -   다음 위치가 배열의 범위를 벗어나지 않는다.
    -   다음 위치가 방문한 적이 없는 위치여야한다.
    -   다음 위치의 picture값이 현재 위치의 picture값과 같아야 한다.
-   BFS에서 어떤 위치를 방문할 때마다 `sizeOfOneArea`의 값을 1씩 늘려준다.
-   BFS의 메서드가 종료되기 직전 `numberOfArea`의 값을 1 늘려주고, `sizeOfOneArea`가 최댓값인지 확인한다.

## 후기

---

BFS라 쉬웠다

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_카카오프렌즈컬러링북.java)
