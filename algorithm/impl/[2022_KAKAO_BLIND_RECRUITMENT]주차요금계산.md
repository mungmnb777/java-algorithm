# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/92341)

## 🚩 주요 키워드

---

-   구현 문제

## 🔑 풀이

---

Map을 사용해서 record에 대한 정보를 저장했다.

-   오늘 출차하지 않은 차량 시간 정산 로직

```java
Set<String> inCarNumber = inMinuteMap.keySet();

for (String carNumber : inCarNumber) {
    if (!parkingMinuteMap.containsKey(carNumber)) {
        parkingMinuteMap.put(carNumber, parseMinute("23:59") - inMinuteMap.get(carNumber));
    } else {
        parkingMinuteMap.put(carNumber, parkingMinuteMap.get(carNumber) + parseMinute("23:59") - inMinuteMap.get(carNumber));
    }
}
```

출차를 하게 되면 `inMinuteMap`에서 차량 정보가 제거되도록 구현했기 때문에 Map에 key가 있다면 오늘 출차하지 않았다는 뜻이다. 이러한 차량에 대한 시간을 정산하는 로직이다.

-   주차 비용 정산 로직

```java
// 정산하기
for (String car : parkingCarNumber) {
    int parkingMinute = parkingMinuteMap.get(car);

    // 주차 시간이 기본 시간 이하라면
    if (parkingMinute <= fees[0]) {
        answer.add(fees[1]);
    }
    // 그렇지 않으면
    else {
        // 기본 시간만큼 뺀 값에서 단위 시간 당 금액을 계산해야함
        int unitMinute;

        if ((parkingMinute - fees[0]) % fees[2] == 0) {
            unitMinute = (parkingMinute - fees[0]) / fees[2];
        } else {
            unitMinute = (parkingMinute - fees[0]) / fees[2] + 1;
        }

        // 기본 요금에 단위 시간 당 요금 추가
        answer.add(unitMinute * fees[3] + fees[1]);
    }
}
```

주차 비용을 정산하는 로직이다. 문제 조건에 맞춰 구현했다.

## 후기

---

클래스도 같이 사용해서 구현했으면 더욱 쉽게 풀 수 있지 않았을까...

# [[전체 코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_주차요금계산.java)
