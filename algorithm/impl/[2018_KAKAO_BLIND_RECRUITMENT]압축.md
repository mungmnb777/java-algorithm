# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17684)

# 🚩 주요 키워드

-   포인터와 인덱스 관리만 잘하면 될 것 같은 구현 문제??

# 🔑 풀이

1. 우선 반복문 안에 들어오면 먼저 포인터가 문자열의 참조 범위를 벗어났는지부터 체크
    1. 만약 벗어났으면 마지막으로 answerList에 사전에서 temp를 참조하여 value를 answer에 넣는다
2. 현재 참조하고 있는 위치의 char를 StringBuilder에 넣는다.
3. StringBuilder에 있는 문자열이 사전에 있는지 체크
    1. 만약 사전에 있으면 다음 인덱스를 탐색
    2. 만약 사전에 없으면 그 문자열을 사전에 저장한다. 그리고 이전 포인터의 상태로 StringBuilder의 길이를 조정하고 그 문자열을 사전에서 찾아 value를 answer에 넣는다. 그 후 StringBuilder를 초기화한다.

# 후기

할만하니까 재밌네요

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_압축.java)
