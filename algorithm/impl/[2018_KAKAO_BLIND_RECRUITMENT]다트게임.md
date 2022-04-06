# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17683)

## 🚩 주요 키워드

---

-   `1S2D*3T`라면 `1S`, `2D`, `*`, `3T`로 나누어서 했음
-   S, D, T가 나올 때마다 인덱스를 늘리는 방식으로 해서 \*이나 #을 사용할 경우에 인덱스에 1을 빼준 값으로 배열을 찾아가야 원하는 점수에 연산을 할 수 있음(바꾸고 싶은데 아이디어가 안떠오름)
-   정수값은 temp 변수에 저장해두었다가 나중에 S, D, T를 만나면 `Integer.parseInt()`로 정수로 변환해서 사용

## 🔑 풀이

---

```java
if (map.containsKey(cur)) {
    int tempScore = Integer.parseInt(temp);
    score[index++] = (int) Math.pow(tempScore, map.get(cur));
}
```

‘S’, ‘D’, ‘T’가 들어온 경우 앞에 받았던 정수에 각각 1의 제곱, 2의 제곱, 3의 제곱을 해주라는 뜻.

`tempScore` : 앞에 받았던 정수

`map` : ‘S’, ‘D’, ‘T’를 키로 하는 `hashMap<>()`임, 각각 1, 2, 3을 value로 가지고 있음

```java
private static void option(int[] score, int index, char mode) {
        switch (mode) {
            case '*':
                if (index != 0) score[index - 1] *= 2;
                score[index] *= 2;
                break;
            case '#':
                score[index] *= -1;
                break;
        }
    }
```

‘\*’, ‘#’가 들어온 경우 메서드 실행함

mode에 따라서 다른 분기의 로직을 실행한다.

## 후기

---

옵션 메서드를 다룰 때 파라미터로 index - 1이 아니라 index를 넣게하고 싶은데 직관적인 방법이 떠오르지 않네요

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_다트게임.java)
