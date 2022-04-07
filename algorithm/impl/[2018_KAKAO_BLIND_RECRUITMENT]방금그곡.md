# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/17683)

# 🚩 주요 키워드

-   Music 클래스 만들어서 클래스 내부에서 다 처리하도록 구현했음
-   `A# → a`, `C# -> c`등 #이 붙은건 소문자로 치환해서 하면 구현이 편함

# 🔑 풀이

-   생성자

```java
public Music(String musicInfo) {
    String[] split = musicInfo.split(",");

    start = split[0];
    end = split[1];
    title = split[2];
    score = replaceString(split[3]);

    init();
}
```

생성자를 통해서 필드 값을 전부 초기화할 수 있음. init() 메서드를 통해 playtime과 scoreForPlaytime 변수도 필드 초기화함(init() 내부에는 setter를 사용하는데 setter는 커스텀해서 사용)

# 후기

C#을 c로 치환하는 방법을 몰랐을 때는 어떻게 구현해야 할지 고민이 많았다.

쉽게 푸는 방법을 알게되어서 다음에 또 활용해볼 수 있는 기회가 왔으면 좋겠다

# [[코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_방금그곡.java)
