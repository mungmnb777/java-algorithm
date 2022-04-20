# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/60057)

## 🚩 주요 키워드

---

-   압축 알고리즘을 구현해야 한다.

```java
private static String pressure(List<String> list) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        String prev = "";
        for (String cur : list) {
            // 현재 스트링이 이전 스트링과 같다면
            if (cur.equals(prev)) {
                count++;
            } else {
                if (count == 0 || count == 1) sb.append(prev);
                else sb.append(count + prev);

                count = 1;
            }
            prev = cur;
        }
        if (count == 0 || count == 1) sb.append(prev);
        else sb.append(count + prev);

        String temp = sb.toString();
        return temp;
    }
```

## 🔑 풀이

---

-   입력으로 받은 문자열을 substring으로 나눈다. 이 때 substring의 길이는 1부터 시작해서 1씩 증가한다. 이 substring은 리스트에 넣어둔다.
-   압축 알고리즘을 구현해서 list의 정보를 이용해서 문자열을 압축하고, 그 압축한 문자열을 리턴한다.
-   리턴한 문자열의 길이를 체크한다.

## 후기

---

압축하는 알고리즘을 완전 하드코딩해서 구현했다... 조금 더 좋은 방법이 있었을 것 같은데 아이디어가 떠오르지 않음,,

# [[전체 코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_문자열압축.java)
