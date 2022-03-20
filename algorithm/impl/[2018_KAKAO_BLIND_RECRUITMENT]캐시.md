# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17680)

### 구현 문제

1. 모든 도시는 대소문자를 구분하지 않으므로 toLowerCase() 메서드를 통해 소문자로 변환하여 비교한다.
2. 현재 검색 중인 도시를 캐시(리스트)의 value들과 비교한다.

    2-1. 캐시에 있으면 실행 시간을 1 증가시키고 캐시에서 현재 도시를 지운다.

    2-2. 캐시에 없으면 실행 시간을 5 증가시킨다.

3. 현재 검색 중인 도시를 캐시에 추가한다.
4. 만약 캐시의 크기가 cacheSize를 초과한다면 캐시 리스트의 0번째 요소를 삭제한다. (0번째 요소가 가장 오래된 value이므로)
5. 검색할 city가 남아있으면 1번으로 돌아간다.
6. answer를 return한다.

# [[풀이]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_캐시.java)
