# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17679)

## 🚩 주요 키워드

---

-   주요 메서드
    -   2 x 2 탐색 범위 내에서 모든 char가 일치하는지 체크하는 `match()`
        -   코드
            ```java
            private static void match(int m, int n, char[][] map) {
                // 2 x 2 사각형 탐색 범위
                Location[] loc = new Location[4];
                loc[0] = new Location(m, n);
                loc[1] = new Location(m, n + 1);
                loc[2] = new Location(m + 1, n);
                loc[3] = new Location(m + 1, n + 1);

                int height = map.length;
                int width = map[0].length;

                // 가장 오른쪽 아래의 위치가 배열의 범위를 벗어나면 바로 리턴
                if (loc[3].r < 0 || loc[3].r >= height ||
            				loc[3].c < 0 || loc[3].c >= width) {
            			return;
            		}

                char initCharacter = map[loc[0].r][loc[0].c];

                for (int i = 0; i < 4; i++) {
                    // 0인 값이 있다면 바로 return
                    if (map[loc[i].r][loc[i].c] == '0') return;
                    // 만약 모든 값이 다 같지 않다면 return;
                    if (initCharacter != map[loc[i].r][loc[i].c]) return;
                }

                Collections.addAll(set, loc);
            }
            ```
    -   비워져 있는 부분을 위에 있는 블록을 떨어뜨려 채워주는 `fall()`
        -   코드
            ```java
            private static void fall(int r, int c, char[][] map) {
                int cr = r;
                while (--cr >= 0) {
                    map[cr + 1][c] = map[cr][c];
                    map[cr][c] = '0';
                }
            }
            ```
    -   위치 정보를 중복 없이 저장하기 위해 Set 컬렉션 사용

## 🔑 풀이

---

1. String[] 자료형으로 받아온 입력 값을 char[][] 자료형으로 변환하여 사용한다.
2. (2 x 2) 탐색 범위를 가지고 전체 배열을 완전 탐색한다. (**_match() 메서드 이용)_**
    1. 탐색 범위 내에서 모든 위치에서 같은 값을 가진다면 모든 위치 객체를 컬렉션(HashSet)에 넣는다.
3. 컬렉션에 값이 있는지 확인한다.
    1. 값이 없으면 메서드를 진행할 필요가 없다. (루프 탈출 → 6번을 진행한다.)
    2. 값이 있으면 컬렉션에 존재하는 모든 위치 객체를 꺼내서 해당하는 위치의 값을 `‘0’`으로 치환한다. (`’0’`은 공간이 비어있다는 의미)
4. 비어있는 부분 위에 블록이 있으면 위에 있는 블록을 전부 떨어뜨린다. (**_fall() 메서드 이용_**)
5. 다음 루프에서 컬렉션을 재사용하기 위해 초기화시켜준다.
6. 루프를 탈출하면 맵에서 `‘0’`인 개수를 체크한다. 그 개수가 답!!

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_프렌즈4블록.java)
