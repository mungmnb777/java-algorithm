# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17678)

## 구현 문제입니다

answer를 결정짓는 주요 조건은

- 마지막 버스에 자리가 남아있는가
    - 이 때는 마지막 버스의 시간을 answer에 담으면 됨
- 마지막 버스에 자리가 없는가
    - 이 때는 마지막 버스를 마지막에 탄 사람의 시간보다 1분 빠른 시간을 answer에 담으면 됨
    - ex) 만약 마지막에 탄 사람이 “09:00”이면 answer는 “08:59”가 됨

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_셔틀버스.java)
