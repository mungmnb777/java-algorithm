# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17687)

## 🚩 주요 키워드

-   이진수로 바꾸는 메서드만 만들면 된다.

```java
private String getNumberFormat(int n, int num) {
    StringBuilder sb = new StringBuilder();

    if (num == 0) {
        return "0";
    }

    while (num != 0) {
        int mod = num % n;

        if (mod >= 10) {
            sb.append((char) ('A' + mod - 10));
        } else {
            sb.append(num % n);
        }

        num /= n;
    }

    return sb.reverse().toString();
}
```

## 🔑 풀이

`getNumberFormat()` 메서드를 통해 바꾼 문자열을 튜브의 순서가 오면 `charAt()`으로 가져가고 StringBuilder에 원하는 갯수만큼 얻게되면 반복문을 탈출하여 값을 리턴한다.

## 후기

어렵진 않았던 것 같다.

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_n진수게임.java)
