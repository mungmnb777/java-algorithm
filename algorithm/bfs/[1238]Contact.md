# [[문제]](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=contact&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&)

### BFS 알고리즘을 활용했다.

우선 그래프 형태이므로 인접 배열이나 인접 리스트를 활용한다.

인접 배열로 정점과 간선에 대한 정보를 저장하고 그 정보를 활용하여 BFS 알고리즘을 돌린다. bfs를 돌리면서 현재 방문 위치의 다음 위치를 큐에 넣을 때, 방문 체크를 하고 현재 방문 위치의 깊이 값에 + 1을 하여 저장한다.

BFS를 다 돌리고 난 후 가장 깊이가 깊은 값을 가진 정점을 가져와서 크기 비교를 하고, 가장 높은 정점을 출력하면 된다.

# [[풀이]](https://github.com/mungmnb777/java-algorithm/tree/main/code/swea/Solution_1238_Contact)